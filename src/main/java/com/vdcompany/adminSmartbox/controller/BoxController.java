package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdcompany.adminSmartbox.bean.BrandVO;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreListVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.box.BoxUpdateLogVO;
import com.vdcompany.adminSmartbox.bean.box.BoxVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.BoxService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/box")
public class BoxController {
	@Autowired
	BoxService boxService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;

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
		List<BoxVO> boxList = boxService.getBoxList();
		
		List<AgencyVO> agencyList = agencyService.getAgencyList();


		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("boxList", boxList);
		mav.addObject("agencyList", agencyList);
		return mav;
	}

	@RequestMapping("/boxList/json")
	private void boxListJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
		String crudType = request.getParameter("type");
		System.out.println("crudType : " + crudType);
		logger.info("crudType : " + crudType);
		switch (crudType){
			case "get":
				// agency_idx 가 0일경우 전체 지점 리스트가 나온다
				List<BoxVO> boxList = boxService.getBoxList();

				Gson gson = new Gson();
				ObjectMapper mapper = new ObjectMapper();
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(gson.toJson(boxList));
				break;
		}


	}

	@RequestMapping("/inventoryInfo")
	private ModelAndView inventoryInfo(Model model, HttpServletRequest request) {
		String url = "/box/inventoryInfo";
		ModelAndView mav = new ModelAndView(url);

		// agency_idx 가 0일경우 전체 지점 리스트가 나온다
		List<BoxVO> boxList = boxService.getBoxList();

		List<AgencyVO> agencyList = agencyService.getAgencyList();


		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("boxList", boxList);
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


		List<AgencyStoreVO> storeList = agencyService.getStoreList(Integer.parseInt(box.getAgc_idx()));
		model.addAttribute("storeList", storeList);

		List<CategoryVO> cateList = cateService.getCateList("STOAR");
		model.addAttribute("cateList", cateList);

		for (CategoryVO cate :cateList) {
			if(box.getCate() != null && box.getCate().equals(cate.getCate_vu()))  {
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
		
		if(box.getAgc_idx() == null || box.getAgc_idx().equals("") || box.getAgc_idx().equals("0")) {
			errorLog = "본사를 선택하세요.";
		} else if(box.getStore_idx() == null || box.getStore_idx().equals("") || box.getStore_idx().equals("0")){
			errorLog = "지점을 선택하세요.";
		} else if(box.getSerial() == null || box.getSerial().equals("")){
			errorLog = "시리얼넘버를 입력하세요.";
		} else if(box.getBox_id() == null || box.getBox_id().equals("")){
			errorLog = "박스ID를 입력하세요.";
		} else if(box.getBox_name() == null || box.getBox_name().equals("")){
			errorLog = "박스명을 입력하세요.";
		}

		return errorLog;
	}

}













