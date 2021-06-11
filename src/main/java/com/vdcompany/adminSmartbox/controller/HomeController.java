package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuSubVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuVO;
import com.vdcompany.adminSmartbox.service.BoxService;
import com.vdcompany.adminSmartbox.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	HomeService homeService;

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
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		//일단위 매출 정보
		List<PaymentPerDayVO> paymentPerDayVOList = homeService.getPaymentInfoPerDay();
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(paymentPerDayVOList));

		//오늘 거래량
		List<PaymentPerDayVO> todayPayCountList = paymentPerDayVOList.stream().filter(o->o.getDaytime().equals(new SimpleDateFormat("yy-MM-dd").format(new Date()))).collect(Collectors.toList());
		String todayPayCount = "0";
		if(!todayPayCountList.isEmpty()){
			todayPayCount = todayPayCountList.get(0).getCustomer_cnt();
		}
		//전날 거래량
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
		String yesterday = new SimpleDateFormat("yy-MM-dd").format(calendar.getTime());
		System.out.println("ys:"+yesterday);
		List<PaymentPerDayVO> yesterdayPayCountList = paymentPerDayVOList.stream().filter(o->o.getDaytime().equals(yesterday)).collect(Collectors.toList());
		String yesterdayPayCount = "0";
		if(!todayPayCountList.isEmpty()){
			yesterdayPayCount = yesterdayPayCountList.get(0).getCustomer_cnt();
		}
		//전일 대비 증감 건수
		int rateChangeCount = Integer.parseInt(todayPayCount) - Integer.parseInt(yesterdayPayCount);


		//월단위 매출 정보
		List<PaymentPerDayVO> paymentPerMonthVOList = homeService.getPaymentInfoPerMonth();
		//logger.info("paymentPerMonthVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(paymentPerMonthVOList));

		//지난달 판매순위 탑10
		List<PaymentPerDayVO> lastMonthSalesTopVOList = homeService.getSalesHitTopList();
		logger.info("lastMonthSalesTopVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(lastMonthSalesTopVOList));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("todayPayCount", todayPayCount);
		mav.addObject("rateChangeCount", rateChangeCount);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("paymentPerDayListInfo", paymentPerDayVOList);
		mav.addObject("paymentPerMonthListInfo", paymentPerMonthVOList);
		mav.addObject("lastMonthSalesTopListInfo", lastMonthSalesTopVOList);

		return mav;
	}

}













