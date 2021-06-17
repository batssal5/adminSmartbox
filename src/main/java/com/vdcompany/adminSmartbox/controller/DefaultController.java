package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.vdcompany.adminSmartbox.AdminSmartboxApplication;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuSubVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.service.BoxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreListVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/default")
public class DefaultController {
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;
	@Autowired
	BoxService boxService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String pageTitle = "기본설정";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"약관관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"사용자APP\",\n" +
			"               \"link_url\":\"/default/userApp\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자APP\",\n" +
			"               \"link_url\":\"/default/adminApp\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"사업자관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"사업자설정\",\n" +
			"               \"link_url\":\"/default/agencyMng\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"매장관리\",\n" +
			"               \"link_url\":\"/default/storeMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"어플관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"버전설정\",\n" +
			"               \"link_url\":\"/default/appVersion\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"제한설정\",\n" +
			"               \"link_url\":\"/default/appAuth\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"환불정책\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"환불설정\",\n" +
			"               \"link_url\":\"/default/refundMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"결제수단관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"카드설정\",\n" +
			"               \"link_url\":\"/default/paymentCardMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//

	@RequestMapping("/userApp")
	private ModelAndView userApp(Model model, HttpServletRequest request) {
		String url = "/default/userApp";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		return mav;
	}

	@RequestMapping("/adminApp")
	private ModelAndView adminApp(Model model, HttpServletRequest request) {
		String url = "/default/adminApp";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		return mav;
	}

	@RequestMapping("/agencyMng")
	private ModelAndView agencyMng(Model model, HttpServletRequest request) {
		String page_url = "/default/agencyMng";
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


	@RequestMapping("/agencyMng/json")
	private void agencyMngJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
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
				List<AgencyVO> agencyInfoList = agencyService.getAgencyInfo(pagingVO);

				mapResp.put("data", agencyInfoList);
				if(requireTotalCount){
					List<AgencyVO> agencyInfoCount = agencyService.getAgencyInfo(new PagingVO());
					mapResp.put("totalCount", agencyInfoCount.size());
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

	@RequestMapping("/storeMng")
	private ModelAndView storeMng(Model model, HttpServletRequest request) {
		String url = "/default/storeMng";
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
	@RequestMapping("/storeMng/json")
	private void storeMngJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
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
				List<AgencyVO> agencyInfoList = agencyService.getAgencyInfo(pagingVO);

				logger.info("xxxxxxxxxxxxxxxxxxxxx:"+new Gson().toJson(agencyInfoList));
				mapResp.put("data", agencyInfoList);
				if(requireTotalCount){
					List<AgencyVO> agencyInfoCount = agencyService.getAgencyInfo(new PagingVO());
					mapResp.put("totalCount", agencyInfoCount.size());
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

	@RequestMapping("/appVersion")
	private ModelAndView appVersion(Model model, HttpServletRequest request) {
		String url = "/default/appVersion";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);



		return mav;
	}

	@RequestMapping("/appAuth")
	private ModelAndView appAuth(Model model, HttpServletRequest request) {
		String url = "/default/appAuth";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		return mav;
	}

	@RequestMapping("/refundMng")
	private ModelAndView refundMng(Model model, HttpServletRequest request) {
		String url = "/default/refundMng";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		return mav;
	}

	@RequestMapping("/paymentCardMng")
	private ModelAndView paymentCardMng(Model model, HttpServletRequest request) {
		String url = "/default/paymentCardMng";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		return mav;
	}
/*
	@RequestMapping("/agencyList")
	private String agencyList(Model model, HttpServletRequest request) {

		System.out.println("agency_idx : " +request.getParameter("agency_idx"));
		
		int agency_idx = 0;
		if(request.getParameter("agency_idx") != null) {
			agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
		}
		 
		// agency_idx 가 0일경우 전체 지점 리스트가 나온다
		List<AgencyStoreVO> storeList = agencyService.getStoreList(agency_idx);
		model.addAttribute("storeList", storeList);
		
		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);
		
		List<CategoryVO> cateList = cateService.getCateList("STOAR");
		model.addAttribute("cateList", cateList);
		
		return "/default/agencyList";
	}
	 */

}













