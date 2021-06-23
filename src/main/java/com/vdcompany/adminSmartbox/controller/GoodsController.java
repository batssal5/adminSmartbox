package com.vdcompany.adminSmartbox.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.AdminSmartboxApplication;
import com.vdcompany.adminSmartbox.bean.DataDTO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.utils.FileUtil;
import com.vdcompany.adminSmartbox.utils.QueryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import com.vdcompany.adminSmartbox.service.GoodsService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	@Autowired
	CategoryService cateService;
	@Autowired
	AgencyService agencyService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String pageTitle = "상품";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"상품관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"상품리스트\",\n" +
			"               \"link_url\":\"/goods/goodsList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"상품진열\",\n" +
			"               \"link_url\":\"/goods/goodsList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"상품가격\",\n" +
			"               \"link_url\":\"/goods/goodsList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"상품재고\",\n" +
			"               \"link_url\":\"/goods/goodsList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"상품기한\",\n" +
			"               \"link_url\":\"/goods/goodsList\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";


	@RequestMapping("/goodsList")
	private ModelAndView agencyMng(Model model, HttpServletRequest request) {
		String page_url = "/goods/goodsList";
		ModelAndView mav = new ModelAndView(page_url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		return mav;
	}


	@RequestMapping("/goodsList/json")
	private void agencyMngJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
		QueryUtils queryUtils = new QueryUtils();
		String WHERE = "";
		PagingVO pagingVO = new PagingVO();
		pagingVO.setType(request.getParameter("type"));
		boolean requireTotalCount = false;
		if(request.getParameter("skip")!=null) {
			logger.info("skip---------------");
			pagingVO.setSkip(Integer.parseInt(request.getParameter("skip")));
		}
		if(request.getParameter("take")!=null) {
			logger.info("take---------------");
			pagingVO.setTake(Integer.parseInt(request.getParameter("take")));
		}
		if(request.getParameter("requireTotalCount")!=null && request.getParameter("requireTotalCount").equals("true")) {
			logger.info("requireTotalCount---------------");
			requireTotalCount = true;
			pagingVO.setRequireTotalCount(request.getParameter("requireTotalCount"));
		}
		if(request.getParameter("filter")!=null && !request.getParameter("filter").equals("")) {
			String filterStr = request.getParameter("filter");
			logger.info("filter---------------:"+filterStr);
			List<Object> fList = new Gson().fromJson(filterStr, List.class);
			WHERE = queryUtils.whereFilter(fList);
			logger.info("WHERE:"+WHERE);
			pagingVO.setFilter(WHERE);
		}

		logger.info("crudType : " + pagingVO.getType());
		Map<String, Object> mapResp = new HashMap<>();
		response.setContentType("application/json;charset=UTF-8");
		AgencyVO agencyVO  = new AgencyVO();
		GoodsVO goodsVO  = new GoodsVO();
		switch (pagingVO.getType()){
			case "put":
				String putDataString = request.getParameter("values");
				logger.info("putDataString:"+putDataString);
				agencyVO  =  new Gson().fromJson(putDataString, AgencyVO.class);
				logger.info("agencyVO:"+new Gson().toJson(agencyVO));
				List<AgencyVO> putRst = new ArrayList<>();
				putRst = agencyService.putAgencyInfo(agencyVO);
				if(putRst.size()>0) {
					response.getWriter().write(new Gson().toJson(putRst.get(0)));
				}
				break;
			case "get":
				List<GoodsVO> goodsList = goodsService.getGoodsList(pagingVO);
				mapResp.put("data", goodsList);
				if(requireTotalCount){
					PagingVO pagingCountVO = new PagingVO();
					if(!WHERE.equals("")){
						pagingCountVO.setFilter(WHERE);
					}
					List<GoodsVO> goodsListCount = goodsService.getGoodsList(pagingCountVO);
					mapResp.put("totalCount", goodsListCount.size());
				}
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
			case "post":
				String postKey = request.getParameter("key");
				String postDataString = request.getParameter("values");
				logger.info("postKey:"+postKey);
				logger.info("postDataString:"+postDataString);
				goodsVO  =  new Gson().fromJson(postDataString, GoodsVO.class);
				goodsVO.setIdx(Integer.parseInt(postKey));
				logger.info("goodsVO:"+new Gson().toJson(goodsVO));
				List<GoodsVO> postRst = new ArrayList<>();
				if(postKey!=null && !postKey.equals("")) {
					postRst = goodsService.postGoodsList(goodsVO);
				}
				if(postRst.size()>0) {
					response.getWriter().write(new Gson().toJson(postRst.get(0)));
				}
				break;
			case "delete":
				String deleteKey = request.getParameter("key");
				logger.info("deleteKey:"+deleteKey);
				agencyVO.setIdx(Integer.parseInt(deleteKey));
				int delBoxRst = agencyService.delAgencyInfo(agencyVO);
				logger.info("delBoxRst:"+delBoxRst);

				break;
		}
	}



	@RequestMapping(value = "/goodsList/imageUpload", method = RequestMethod.POST, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void imageUpload(@RequestParam("filedata") MultipartFile filedata, HttpServletResponse response) throws IOException {
		String result = "";
		String page_url = "/goods/uploadStatus";
		ModelAndView mav = new ModelAndView(page_url);

		String rootPath = "D:\\smartbox_service\\smartbox_root\\smartbox_images\\smartbox\\goods\\";
		//String rootPath = "D:/temp/";
		String basePath = rootPath+filedata.getOriginalFilename();
		logger.info("basePath:"+basePath);


		File bfCheckFile = new File(basePath);
		bfCheckFile.createNewFile();
		if(bfCheckFile.isFile()){
			logger.info("bfCheckFile:getPath - "+bfCheckFile.getPath());
			logger.info("bfCheckFile:getName - "+bfCheckFile.getName());
			logger.info("bfCheckFile:Exist File image - "+basePath);
			String path = bfCheckFile.getPath();
			path = path.replace(bfCheckFile.getName(),"");
			FileUtil fileUtil = new FileUtil();
			String newName = fileUtil.rename(bfCheckFile);
			logger.info("newName - "+newName);
			boolean isMoved = bfCheckFile.renameTo(new File(path+newName));
			logger.info("isMoved - "+isMoved);

		}

		File dest = new File(basePath);
		filedata.transferTo(dest); // 파일 업로드 작업 수행

		File checkFile = new File(basePath);
		if(checkFile.isFile()){
			logger.info("checkFile:Done! - "+basePath);
			result  = AdminSmartboxApplication.getImageCommonURL()+checkFile.getName();
		}
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		response.getWriter().write(result);

	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "/goods/uploadStatus";
	}

}













