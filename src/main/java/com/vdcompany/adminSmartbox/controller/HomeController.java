package com.vdcompany.adminSmartbox.controller;

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

	@RequestMapping("/dashboard")
	private ModelAndView mainPage(Model model, HttpServletRequest request) {
		String pageTitle = "홈";
		String url = "/home/dashboard";
		logger.info("[WEB][webController][mainPage] url:"+url);
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());


		List<LeftMenuVO> leftMenu = new ArrayList<>();
		LeftMenuVO leftMenuVO = new LeftMenuVO();
		leftMenuVO.setMenu_name("주요현황");
		leftMenuVO.setMenu_icon("pe-7s-display2");
		leftMenuVO.setLink_url("/home/dashboard");

		/*List<LeftMenuSubVO> leftMenuSubVOList = new ArrayList<>();
		LeftMenuSubVO leftMenuSubVO = new LeftMenuSubVO();
		leftMenuSubVO.setMenu_name("주요현황");
		leftMenuSubVO.setLink_url("/home/dashboard");
		leftMenuSubVOList.add(leftMenuSubVO);

		leftMenuVO.setLeftMenuSub(leftMenuSubVOList);*/

		leftMenu.add(leftMenuVO);

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenu);

		return mav;
	}

}













