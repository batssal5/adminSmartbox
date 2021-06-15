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
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuSubVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuVO;
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
		String url = "/default/agencyMng";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		int agency_idx = 0;
		if(request.getParameter("agency_idx") != null) {
			agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
		}

		// agency_idx 가 0일경우 전체 지점 리스트가 나온다
		List<AgencyStoreVO> storeList = agencyService.getStoreList(agency_idx);
		model.addAttribute("storeList", storeList);

		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);

		return mav;
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
	
	@RequestMapping("/ajax_store")
	private void ajax_storeList( HttpServletResponse response, Model model, HttpServletRequest request ) throws JsonProcessingException, IOException  {

		
		response.setContentType("text/html;charset=UTF-8"); 

		
		String temp = request.getParameter("agency_idx");
		if(temp != null) {
			
			List<AgencyStoreVO> storeList = new ArrayList<>();
			storeList = agencyService.getStoreList(Integer.parseInt(temp));

			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(storeList));
		}
		
//		System.out.println("--------------------------");
//		System.out.println("agency_idx : " + temp );
//		System.out.println("--------------------------");
	}
	
	@RequestMapping("/ajax_search")
	private void ajax_search( HttpServletResponse response, HttpServletRequest request, AgencySearchVO search ) throws JsonProcessingException, IOException  {

		int agency_idx = 0;
		if(request.getParameter("agency_idx") != null) {
			agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
		}
		int store_idx = 0;
		if(request.getParameter("store_idx") != null) {
			store_idx = Integer.parseInt(request.getParameter("store_idx"));
		}

		search.setAgc_idx(agency_idx);
		search.setIdx(store_idx);
		System.out.println("search : " + search );

		List<AgencyStoreVO> storeList = new ArrayList<>();
		storeList = agencyService.getSearchStoreList(search);
		System.out.println("result : " + storeList);

		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(storeList));
		
	}
	
	
	
	@RequestMapping("/agencyAdd")
	private String agencyAdd(Model model, HttpServletRequest request) {

		List<CategoryVO> cateList = cateService.getCateList("STOAR");
		model.addAttribute("cateList", cateList);

		return "/default/agencyAdd";
	}
	

	@RequestMapping("/ajax_Add")
	private void ajax_AgencyAdd( HttpServletResponse response, HttpServletRequest request, AgencyVO agency, AgencyStoreListVO storeList ) throws JsonProcessingException, IOException  {
		
		System.out.println("agency : " +agency);
		System.out.println("storeList : " +storeList);
		
		response.setContentType("text/html;charset=UTF-8"); 

		// 지점데이터중 행삭제로인한 빈값데이터 필터링 (지점사업자번호가 있는지 없는지로 판단)
		List<AgencyStoreVO> list = new ArrayList<AgencyStoreVO>();
		List<AgencyStoreVO> temp = storeList.getList();
		for (int i = 0 ; i < temp.size() ; i++) {
			if(temp.get(i).getStore_num() != null && !temp.get(i).getStore_num().equals("")) {
				list.add(temp.get(i));
			}
		}
		storeList.setList(list);

		// 유효성체크
		String errorAgency = validAgency(agency);
		if(!errorAgency.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorAgency+"\"}");
			return;
		}
		String errorStore = validStore(list);
		if(!errorStore.equals("")) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorStore+"\"}");
			return;
		}

		// 본사먼저 등록
		int agc_idx = agencyService.insertAgency(agency);
		System.out.println("agc_idx : " +agc_idx);

		if (agc_idx == 0) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"본사 DB등록중 오류가 생겼습니다.\"}");
			return;
		}
		
		// List에 agc_idx 추가 및 빈값데이터 필터링
		for (int i = 0 ; i < list.size() ; i++) {
			list.get(i).setAgc_idx(agc_idx);
		}
		// 지점등록
		int ret = agencyService.insertStoreList(list);

		if (ret > 0) {
			response.getWriter().print("{\"ret\":0 }");
		} else {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"지점 DB등록중 오류가 생겼습니다.\"}");
		}
		
	}
	

	
	
	private String validAgency(AgencyVO agency) {
		
		String errorLog = "";
		
		if(agency.getCompany_name() != null && agency.getCompany_name() == "") {
			errorLog = "본사명을 입력하세요.";
		} else if(agency.getCompany_num() != null && agency.getCompany_num() == ""){
			errorLog = "본사사업자번호를 입력하세요.";
		} else if(agency.getCommission_pg() != null && agency.getCommission_pg() == ""){
			errorLog = "PG수수료를 입력하세요.";
		} else if(agency.getCommission_vd() != null && agency.getCommission_vd() == ""){
			errorLog = "VD수수료를 입력하세요.";
		} else if(agency.getRep_nm() != null && agency.getRep_nm() == ""){
			errorLog = "담당자를 입력하세요.";
		} else if(agency.getRep_email() != null && agency.getRep_email() == ""){
			errorLog = "이메일을 입력하세요.";
		} else if(agency.getRep_mobile() != null && agency.getRep_mobile() == ""){
			errorLog = "휴대전화를 입력하세요.";
		} else if(agency.getRep_tel() != null && agency.getRep_tel() == ""){
			errorLog = "일반전화를 입력하세요.";
		} else if(agency.getZipcode() != null && agency.getZipcode() == ""){
			errorLog = "주소를 입력하세요.";
		} else if(agency.getAddress() != null && agency.getAddress() == ""){
			errorLog = "주소를 입력하세요.";
		} else if(agency.getAddr_detail() != null && agency.getAddr_detail() == ""){
			errorLog = "주소를 입력하세요.";
		}

		return errorLog;
	}

	private String validStore(List<AgencyStoreVO> list) {

		String errorLog = "";

		for(int i = 0 ; i < list.size() ; i++) {
			AgencyStoreVO store = list.get(i);

			if(store.getStore_name() != null && store.getStore_name() == "") {
				errorLog = (i+1)+"번째 지점의"+" 지점명을 입력하세요.";
			} else if(store.getStore_num() != null && store.getStore_num() == ""){
				errorLog = (i+1)+"번째 지점의"+" 지점사업자번호를 입력하세요.";
			} else if(store.getCate() == 0){
				errorLog = (i+1)+"번째 지점의"+" 상권을 선택하세요."+store.getCate();
			} else if(store.getPg_comm() != null && store.getPg_comm() == ""){
				errorLog = (i+1)+"번째 지점의"+" PG수수료를 입력하세요.";
			} else if(store.getVd_comm() != null && store.getVd_comm() == ""){
				errorLog = (i+1)+"번째 지점의"+" VD수수료를 입력하세요.";
			}
			if(errorLog != "") {
				break;
			}
		}

		if(list.size() == 0) {
			errorLog = "지점데이터가 없습니다.";
		}

		return errorLog;
	}

	@RequestMapping("/agencyModify")
	private String agencyModify(Model model, HttpServletRequest request) {

		int idx = Integer.parseInt(request.getParameter("idx"));
		AgencyVO agency = agencyService.getAgencyDetail(idx);
		model.addAttribute("agency", agency);

		List<CategoryVO> cateList = cateService.getCateList("STOAR");
		model.addAttribute("cateList", cateList);

		List<AgencyStoreVO>storeList = agencyService.getStoreList(idx);
		for (AgencyStoreVO store :storeList) {
			for (CategoryVO cate :cateList) {
				if(store.getCate() == Integer.parseInt(cate.getCate_vu()) ) {
//					store.setCate_name(cate.getCate_nm());
					break;
				}
			}
		}
		model.addAttribute("storeList", storeList);
		System.out.println("storeList : " +storeList);

		return "/default/agencyModify";
	}
	
	@RequestMapping("/ajax_Update")
	private void ajax_Update( HttpServletResponse response, HttpServletRequest request, AgencyVO agency, AgencyStoreListVO storeList ) throws JsonProcessingException, IOException  {
		
		System.out.println("agency : " +agency);
		System.out.println("storeList : " +storeList);
		
		response.setContentType("text/html;charset=UTF-8"); 

		// 지점데이터중 행삭제로인한 빈값데이터 필터링 (지점사업자번호가 있는지 없는지로 판단)
		List<AgencyStoreVO> list = new ArrayList<AgencyStoreVO>();
		List<AgencyStoreVO> temp = storeList.getList();
		for (int i = 0 ; i < temp.size() ; i++) {
			if(temp.get(i).getStore_num() != null && !temp.get(i).getStore_num().equals("")) {
				list.add(temp.get(i));
			}
		}
		storeList.setList(list);

		// 유효성체크
		String errorAgency = validAgency(agency);
		if(!errorAgency.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorAgency+"\"}");
			return;
		}
		String errorStore = validStore(list);
		if(!errorStore.equals("")) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorStore+"\"}");
			return;
		}

		// 본사먼저 업데이트
		int agc_idx = agencyService.updateAgency(agency);
		if (agc_idx == 0) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"본사 DB등록중 오류가 생겼습니다.\"}");
			return;
		}
		
		// List에 idx값이 있는경우 update 처리
		// idx값이 없는경우 insert 처리
		List<AgencyStoreVO> updateList = new ArrayList<AgencyStoreVO>();
		List<AgencyStoreVO> insertList = new ArrayList<AgencyStoreVO>();
		for (int i = 0 ; i < list.size() ; i++) {
 			list.get(i).setAgc_idx(agc_idx);
			if(list.get(i).getIdx() > 0) {
				updateList.add(list.get(i));
			} else {
				insertList.add(list.get(i));
			}
		}
		
		int ret = 0;
		System.out.println("updateList : " +updateList.size());
		if(updateList.size() > 0) {
			ret = agencyService.updateStoreList(updateList);
		}
		System.out.println("insertList : " +insertList.size());

		if(insertList.size() > 0) {
			ret = agencyService.insertStoreList(insertList);
		}
		
		
		System.out.println("updateList : " +updateList.size());
		System.out.println("insertList : " +insertList.size());

		
		if (ret == 0) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\" DB등록중 오류가 생겼습니다.\"}");
		} else {
			response.getWriter().print("{\"ret\":0 }");
		}

//		// 지점등록
//		int ret = agencyService.insertStoreList(list);
//
//		if (ret > 0) {
//			response.getWriter().print("{\"ret\":0 }");
//		} else {
//			response.getWriter().print("{\"ret\":-1  ,\"error\":\"지점 DB등록중 오류가 생겼습니다.\"}");
//		}
		
	}
}













