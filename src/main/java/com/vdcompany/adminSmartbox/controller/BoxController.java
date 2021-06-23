package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.vdcompany.adminSmartbox.bean.box.InventoryVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.utils.QueryUtils;
import com.vdcompany.adminSmartbox.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.BoxService;
import com.vdcompany.adminSmartbox.service.CategoryService;

@Controller
@RequestMapping("/box")
public class BoxController {
	@Autowired
	BoxService boxService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;

	StrUtils strUtils = new StrUtils();

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String pageTitle = "박스";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"박스관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"박스리스트\",\n" +
			"               \"link_url\":\"/box/boxList\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"재고관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"재고처리내역\",\n" +
			"               \"link_url\":\"/box/inventoryInfo\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//
	
	@RequestMapping("/boxList")
	private ModelAndView boxList(Model model, HttpServletRequest request) {
		String url = "/box/boxList";
		ModelAndView mav = new ModelAndView(url);
		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		return mav;
	}

	@RequestMapping("/boxList/json")
	private void boxListJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
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
		response.setContentType("text/html;charset=UTF-8");

		switch (pagingVO.getType()){
			case "put":
				String reqValues = request.getParameter("values");
				//logger.info("values:"+reqValues);

				BoxVO boxVO = new Gson().fromJson(reqValues, BoxVO.class);
				//logger.info("values:"+new Gson().toJson(boxVO));

				int boxList = boxService.putBox(boxVO);

				if(requireTotalCount){
					List<BoxVO> boxListCount = boxService.getBoxList(new PagingVO());
					mapResp.put("totalCount", boxListCount.size());
				}
				mapResp.put("data", boxList);
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
			case "get":
				List<BoxVO> boxListGet = boxService.getBoxList(pagingVO);

				mapResp.put("data", boxListGet);
				if(requireTotalCount){
					PagingVO pagingCountVO = new PagingVO();
					if(!WHERE.equals("")){
						pagingCountVO.setFilter(WHERE);
					}
					List<BoxVO> boxListCount = boxService.getBoxList(pagingCountVO);
					mapResp.put("totalCount", boxListCount.size());
				}
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
			case "post":
				String postKey = request.getParameter("key");
				String postDataString = request.getParameter("values");
				logger.info("postKey:"+postKey);
				logger.info("postDataString:"+postDataString);
				Map<String, Object> postMap = new HashMap<>();
				postMap =  new Gson().fromJson(postDataString, HashMap.class);
				postMap.put("key", postKey);
				postMap.put("box_id", postKey);
				List<BoxVO> boxVOList = new ArrayList<>();
				int postBoxRst = -1;
				if(postMap.get("box_id")!=null ) {
					postBoxRst = boxService.postBox(postMap);
					logger.info("postBoxRst:"+postBoxRst);
				}
				//response.getWriter().write(new Gson().toJson(boxVOList.get(0)));
				break;
			case "delete":
				String deleteKey = request.getParameter("key");
				logger.info("deleteKey:"+deleteKey);
				Map<String, Object> deleteMap = new HashMap<>();
				deleteMap.put("box_id", deleteKey);
				int delBoxRst = boxService.deleteBox(deleteMap);
				logger.info("delBoxRst:"+delBoxRst);

				break;
		}
	}



	@RequestMapping("/inventoryInfo")
	private ModelAndView inventoryInfo(Model model, HttpServletRequest request) {
		String page_url = "/box/inventoryInfo";
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


	@RequestMapping("/inventoryInfo/json")
	private void inventoryInfoJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
		QueryUtils queryUtils = new QueryUtils();
		PagingVO pagingVO = new PagingVO();
		pagingVO.setType(request.getParameter("type"));
		boolean requireTotalCount = false;
		String WHERE = "";
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
		response.setContentType("text/html;charset=UTF-8");
		AgencyVO agencyVO  = new AgencyVO();
		switch (pagingVO.getType()){
			case "get":
				List<InventoryVO> agencyInfoList = boxService.getInventoryInfo(pagingVO);

				//logger.info("xxxxxxxxxxxxxxxxxxxxx:"+new Gson().toJson(agencyInfoList));
				mapResp.put("data", agencyInfoList);
				if(requireTotalCount){
					PagingVO pagingCountVO = new PagingVO();
					if(!WHERE.equals("")){
						pagingCountVO.setFilter(WHERE);
					}
					List<InventoryVO> countList = boxService.getInventoryInfo(pagingCountVO);
					mapResp.put("totalCount", countList.size());
				}
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
		}
	}


	@RequestMapping("/inventoryDetailInfo/json")
	private void inventoryDetailInfo( HttpServletResponse response, HttpServletRequest request) throws IOException  {
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


		logger.info("crudType : " + pagingVO.getType());
		Map<String, Object> mapResp = new HashMap<>();
		response.setContentType("text/html;charset=UTF-8");
		AgencyVO agencyVO  = new AgencyVO();
		pagingVO.setIdx(request.getParameter("inv_idx"));
		List<InventoryVO> agencyInfoList = boxService.getInventoryDetailInfo(pagingVO);

		mapResp.put("data", agencyInfoList);
		/*if(requireTotalCount){
			List<InventoryVO> countList = boxService.getInventoryInfo(new PagingVO());
			mapResp.put("totalCount", countList.size());
		}*/
		response.getWriter().write(new Gson().toJson(mapResp));

	}
 
}













