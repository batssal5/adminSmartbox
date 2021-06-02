package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
@RequestMapping("/box")
public class BoxController {
	@Autowired
	BoxService boxService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;

	
	@RequestMapping("/boxList")
	private String boxList(Model model, HttpServletRequest request) {

		
		// agency_idx 가 0일경우 전체 지점 리스트가 나온다
		List<BoxVO> boxList = boxService.getBoxList();
		model.addAttribute("boxList", boxList);
		
		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);

		return "/box/boxList";
	}
	
	@RequestMapping("/ajax_search")
	private void ajax_search( HttpServletResponse response, HttpServletRequest request, BoxVO search ) throws JsonProcessingException, IOException  {
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













