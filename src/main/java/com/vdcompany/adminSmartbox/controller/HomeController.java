package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuSubVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {
	/*@Autowired
	BoxService boxService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;*/

	Logger logger = LoggerFactory.getLogger(this.getClass());
	String pageTitle = "홈";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"주요현황\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":null\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//
	@RequestMapping("/dashboard")
	private ModelAndView mainPage(Model model, HttpServletRequest request) {
		String url = "/home/dashboard";
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













