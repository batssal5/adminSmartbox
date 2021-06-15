package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String pageTitle = "회원";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"회원관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"유저리스트\",\n" +
			"               \"link_url\":\"/member/userList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"블랙리스트\",\n" +
			"               \"link_url\":\"/member/blackUserList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"미납리스트\",\n" +
			"               \"link_url\":\"/member/unpaidList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"탈퇴회원\",\n" +
			"               \"link_url\":\"/member/cancellationUserList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자회원\",\n" +
			"               \"link_url\":\"/member/agencyUserList\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"회원가입제한\",\n" +
			"               \"link_url\":\"/member/signupPolicy\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"푸시관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"푸시발송\",\n" +
			"               \"link_url\":\"/member/sendPushMessage\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//

	@RequestMapping("/paymentList")
	private ModelAndView userApp(Model model, HttpServletRequest request) {
		String url = "/sales/paymentList";
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

	@RequestMapping("/exactCalculation")
	private ModelAndView adminApp(Model model, HttpServletRequest request) {
		String url = "/sales/exactCalculation";
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

	@RequestMapping("/refundList")
	private ModelAndView agencyMng(Model model, HttpServletRequest request) {
		String url = "/sales/refundList";
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













