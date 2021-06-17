package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.utils.StrUtils;
import com.vdcompany.adminSmartbox.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
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

		// agency_idx 가 0일경우 전체 지점 리스트가 나온다
		
		List<AgencyVO> agencyList = agencyService.getAgencyList();


		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("agencyList", agencyList);
		return mav;
	}

	@RequestMapping("/boxList/json")
	private void boxListJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
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

		switch (pagingVO.getType()){
			case "put":
				/*
				{"agc_idx":"2","store_num":"9","box_id":333333,"box_name":"박스명",
				"status":0,"cate":-1,"description":"ssss","serial":"e3344444","store_company_num":"65555555"}
				 */
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
					List<BoxVO> boxListCount = boxService.getBoxList(new PagingVO());
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
		String url = "/box/inventoryInfo";
		ModelAndView mav = new ModelAndView(url);


		List<AgencyVO> agencyList = agencyService.getAgencyList();


		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("agencyList", agencyList);
		return mav;
	}
	
	@RequestMapping("/ajax_search")
	private void ajax_search( HttpServletResponse response, HttpServletRequest request, BoxVO search ) throws IOException  {
		System.out.println("search : " + search );

		List<BoxVO> boxList = boxService.getBoxSearchList(search);

		System.out.println("boxList : " + boxList );

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().print(mapper.writeValueAsString(boxList));
		
	}

	
	@RequestMapping("/boxAdd")
	private String boxAdd(Model model, HttpServletRequest request) {

		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);

		return "/box/boxAdd";
	}
	
	@RequestMapping(value="/ajax_Add", method=RequestMethod.POST)
	private void ajax_Add( HttpServletResponse response, HttpServletRequest request, BoxVO box ) throws JsonProcessingException, IOException  {
		response.setContentType("text/html;charset=UTF-8"); 
		
		System.out.println("box : " +box);

		String errorBox = validBox(box);
		if(!errorBox.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorBox+"\"}");
			return;
		}

		int box_idx = boxService.insertBox(box);
		if (box_idx < 1) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"박스 DB등록중 오류가 생겼습니다.\"}");
		} else {
			response.getWriter().print("{\"ret\":0 }");
		}
	}
	
	@RequestMapping("/boxModify")
	private String boxModify(Model model, HttpServletRequest request) {

		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);


		String idx = request.getParameter("idx");
		BoxVO box = boxService.getBoxDetail(Integer.parseInt(idx));
		model.addAttribute("box", box);
		
		List<BoxUpdateLogVO> boxLogList = boxService.getBoxUpdateLogList(Integer.parseInt(idx));
		model.addAttribute("boxLogList", boxLogList);


		List<AgencyStoreVO> storeList = agencyService.getStoreList(box.getAgc_idx());
		model.addAttribute("storeList", storeList);

		List<CategoryVO> cateList = cateService.getCateList("STOAR");
		model.addAttribute("cateList", cateList);

		for (CategoryVO cate :cateList) {
			if(box.getCate()==cate.getCate_vu())  {
				box.setCate_name(cate.getCate_nm());
				break;
			}
		}

		
		System.out.println("box : " +box);

		return "/box/boxModify";
	}


	@RequestMapping("/ajax_Modify")
	private void ajax_Modify( HttpServletResponse response, HttpServletRequest request, BoxVO box) throws JsonProcessingException, IOException  {
		response.setContentType("text/html;charset=UTF-8"); 
		
		System.out.println("ajax_Modify box : " +box);

		String errorBox = validBox(box);
		if(!errorBox.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorBox+"\"}");
			return;
		}

		int box_idx = boxService.updateBox(box);
		if (box_idx < 1) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"박스 DB등록중 오류가 생겼습니다.\"}");
		} else {
			response.getWriter().print("{\"ret\":0 }");
		}
	}

	
	
	
	private String validBox(BoxVO box) {
		
		String errorLog = "";
		
		if(box.getAgc_idx()==0) {
			errorLog = "본사를 선택하세요.";
		} else if(box.getStore_idx()==0){
			errorLog = "지점을 선택하세요.";
		} else if(box.getSerial() == null || box.getSerial().equals("")){
			errorLog = "시리얼넘버를 입력하세요.";
		} else if(box.getBox_id() == 0 ){
			errorLog = "박스ID를 입력하세요.";
		} else if(box.getBox_name() == null || box.getBox_name().equals("")){
			errorLog = "박스명을 입력하세요.";
		}

		return errorLog;
	}

}













