package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.home.PaymentPerDayVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.jni.BrailleJNI;
import com.vdcompany.adminSmartbox.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/braille")
public class BrailleDllController {
	@Autowired
	HomeService homeService;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	@RequestMapping("/test")
	private void Test(Model model, HttpServletRequest request) {
		BrailleJNI brailleJNI = new BrailleJNI();
		brailleJNI.hello();
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));
		logger.info("test");
	}

}













