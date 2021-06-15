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
		//환불 카운트 정보
		List<PaymentPerDayVO> lastWeekRefoundVOList = homeService.getRefundInfoPerDay();
		//logger.info("lastWeekRefoundVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(lastWeekRefoundVOList));
		int todayRefoundCount = 0;
		int yesterdayRefoundCount = 0;
		if(lastWeekRefoundVOList.size()>0&&lastWeekRefoundVOList.get(0).getDaytime().equals(new SimpleDateFormat("yy-MM-dd").format(new Date()))){
			todayRefoundCount = lastWeekRefoundVOList.get(0).getCount();
		}
		if(lastWeekRefoundVOList.size()>1&&lastWeekRefoundVOList.get(1).getDaytime().equals(yesterday)){
			yesterdayRefoundCount = lastWeekRefoundVOList.get(1).getCount();
		}
		int refoundChangeCount = todayRefoundCount - yesterdayRefoundCount;

		//일단위 사용자 문의 건수 조회
		List<PaymentPerDayVO> userQuestionInfoList = homeService.getUserQuestionInfoPerDay();
		//logger.info("userQuestionInfoList:"+new GsonBuilder().setPrettyPrinting().create().toJson(userQuestionInfoList));
		int todayUserQuestionCount = 0;
		int yesterdayUserQuestionCount = 0;
		if(userQuestionInfoList.size()>0&&userQuestionInfoList.get(0).getDaytime().equals(new SimpleDateFormat("yy-MM-dd").format(new Date()))){
			todayUserQuestionCount = userQuestionInfoList.get(0).getCount();
		}
		if(userQuestionInfoList.size()>1&&userQuestionInfoList.get(1).getDaytime().equals(yesterday)){
			yesterdayRefoundCount = userQuestionInfoList.get(1).getCount();
		}
		int userQuestionChangeCount = todayUserQuestionCount - yesterdayRefoundCount;

		//일단위 관리자 문의 건수 조회
		List<PaymentPerDayVO> agencyQuestionInfoList = homeService.getAgencyQuestionInfoPerDay();
		//logger.info("agencyQuestionInfoList:"+new GsonBuilder().setPrettyPrinting().create().toJson(agencyQuestionInfoList));
		int todayAgencyQuestionCount = 0;
		int yesterdayAgencyQuestionCount = 0;
		if(agencyQuestionInfoList.size()>0&&agencyQuestionInfoList.get(0).getDaytime().equals(new SimpleDateFormat("yy-MM-dd").format(new Date()))){
			todayAgencyQuestionCount = agencyQuestionInfoList.get(0).getCount();
		}
		if(agencyQuestionInfoList.size()>1&&agencyQuestionInfoList.get(1).getDaytime().equals(yesterday)){
			yesterdayAgencyQuestionCount = agencyQuestionInfoList.get(1).getCount();
		}
		int agencyQuestionChangeCount = todayAgencyQuestionCount - yesterdayAgencyQuestionCount;

		//스마트박스 운용 상태 조회
		List<PaymentPerDayVO> smartBoxStatusInfoList = homeService.getSmartBoxStatusInfo();
		logger.info("smartBoxStatusInfoList:"+new GsonBuilder().setPrettyPrinting().create().toJson(smartBoxStatusInfoList));
		int smartBoxOnlineCount = 0;
		int smartBoxOfflineCount = 0;
		if(smartBoxStatusInfoList.size()>0){
			smartBoxOnlineCount = smartBoxStatusInfoList.get(0).getOnline();
			smartBoxOfflineCount = smartBoxStatusInfoList.get(0).getOffline();
		}

		//월단위 매출 정보
		List<PaymentPerDayVO> paymentPerMonthVOList = homeService.getPaymentInfoPerMonth();
		//logger.info("paymentPerMonthVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(paymentPerMonthVOList));

		//지난달 판매순위 탑10
		List<PaymentPerDayVO> lastMonthSalesTopVOList = homeService.getSalesHitTopList();
		//logger.info("lastMonthSalesTopVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(lastMonthSalesTopVOList));

		//지난달 판매순위 탑10 boxinfo
		List<PaymentPerDayVO> lastMonthSalesTopBoxVOList = homeService.getSalesHitTopPerBoxList();
		//logger.info("lastMonthSalesTopBoxVOList:"+new GsonBuilder().setPrettyPrinting().create().toJson(lastMonthSalesTopBoxVOList));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("todayPayCount", todayPayCount);
		mav.addObject("todayRefoundCount", todayRefoundCount);
		mav.addObject("refoundChangeCount", refoundChangeCount);
		mav.addObject("todayUserQuestionCount", todayUserQuestionCount);
		mav.addObject("userQuestionChangeCount", userQuestionChangeCount);
		mav.addObject("todayAgencyQuestionCount", todayAgencyQuestionCount);
		mav.addObject("agencyQuestionChangeCount", agencyQuestionChangeCount);
		mav.addObject("smartBoxOnlineCount", smartBoxOnlineCount);
		mav.addObject("smartBoxOfflineCount", smartBoxOfflineCount);
		mav.addObject("rateChangeCount", rateChangeCount);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		mav.addObject("paymentPerDayListInfo", paymentPerDayVOList);
		mav.addObject("paymentPerMonthListInfo", paymentPerMonthVOList);
		mav.addObject("lastMonthSalesTopListInfo", lastMonthSalesTopVOList);
		mav.addObject("lastMonthSalesTopBoxListInfo", lastMonthSalesTopBoxVOList);
		mav.addObject("lastWeekRefoundListInfo", lastWeekRefoundVOList);

		return mav;
	}

}













