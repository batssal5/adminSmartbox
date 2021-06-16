package com.vdcompany.adminSmartbox.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.board.BoardAgencySearchVO;
import com.vdcompany.adminSmartbox.bean.board.BoardAgencyVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.BoardService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	AgencyService agencyService;

	@Autowired
	BoardService boardService;

	@Autowired
	CategoryService cateService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String pageTitle = "게시판";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"관리자\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자1:1문의\",\n" +
			"               \"link_url\":\"/board/agencyQuestion\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자FAQ\",\n" +
			"               \"link_url\":\"/board/agencyFAQ\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자 공지사항\",\n" +
			"               \"link_url\":\"/board/agencyNoticeBoard\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자 프로모션\",\n" +
			"               \"link_url\":\"/board/agencyPromotion\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"유저\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"유저1:1문의\",\n" +
			"               \"link_url\":\"/board/userQuestion\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"유저FAQ\",\n" +
			"               \"link_url\":\"/board/userFAQ\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"유저 공지사항\",\n" +
			"               \"link_url\":\"/board/userNoticeBoard\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"유저 이벤트\",\n" +
			"               \"link_url\":\"/board/userEvent\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//

	@RequestMapping("/agencyQuestion")
	private ModelAndView agencyQuestion(Model model, HttpServletRequest request) {
		String url = "/board/agencyQuestion";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);

		int agency_idx = 0;
		if (request.getParameter("agency_idx") != null){
			agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
		}

		List<BoardAgencyVO> agcList = boardService.getBoardAgency();
		model.addAttribute("agcList", agcList);



		List<BoardAgencyVO> agency_quelist = boardService.getBoardAgencyList(agency_idx);
		model.addAttribute("agency_quelist",agency_quelist);
		System.out.println(agency_quelist);

		return mav;
	}

	@RequestMapping("/ajax_search")
	private void ajax_search(HttpServletResponse response, HttpServletRequest request, BoardAgencySearchVO search) throws JsonProcessingException, IOException{

		int agc_idx = 0;
		if(request.getParameter("agc_idx") != null) {
			agc_idx = Integer.parseInt(request.getParameter("agc_idx"));
		}

		int store_idx = 0;
		if(request.getParameter("store_idx") != null) {
			store_idx = Integer.parseInt(request.getParameter("store_idx"));
		}

		String company_num = request.getParameter("company_num");
		System.out.println("company_num:" + company_num);

		search.setAgc_idx(agc_idx);
		search.setStore_idx(store_idx);
		search.setCompany_num(company_num);
		System.out.println("^^^^^^^^^^^^^^^^^^^" + search);

		List<BoardAgencyVO> queList = new ArrayList<>();
		queList = boardService.getBoardAgencySearchList(search);
		System.out.println("result : " + queList);

		response.setContentType("text/html;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(queList));
	}


	@RequestMapping("/agencyFAQ")
	private ModelAndView agencyFAQ(Model model, HttpServletRequest request) {
		String url = "/board/agencyFAQ";
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

	@RequestMapping("/agencyNoticeBoard")
	private ModelAndView agencyNoticeBoard(Model model, HttpServletRequest request) {
		String url = "/board/agencyNoticeBoard";
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

	@RequestMapping("/agencyPromotion")
	private ModelAndView agencyPromotion(Model model, HttpServletRequest request) {
		String url = "/board/agencyPromotion";
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


	@RequestMapping("/userQuestion")
	private ModelAndView userQuestion(Model model, HttpServletRequest request) {
		String url = "/board/userQuestion";
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

	@RequestMapping("/userFAQ")
	private ModelAndView userFAQ(Model model, HttpServletRequest request) {
		String url = "/board/userFAQ";
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

	@RequestMapping("/userNoticeBoard")
	private ModelAndView userNoticeBoard(Model model, HttpServletRequest request) {
		String url = "/board/userNoticeBoard";
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

	@RequestMapping("/userEvent")
	private ModelAndView userEvent(Model model, HttpServletRequest request) {
		String url = "/board/userEvent";
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


}













