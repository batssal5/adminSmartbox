package com.vdcompany.adminSmartbox.controller;

import com.vdcompany.adminSmartbox.AdminSmartboxApplication;
import com.vdcompany.adminSmartbox.jni.BrailleJavaInterCaller;
import com.vdcompany.adminSmartbox.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import net.sf.jni4net.Bridge;

import java.io.File;
import java.io.IOException;

import myjni.MyJni;

@Controller
@RequestMapping("/braille")
public class BrailleDllController {
	@Autowired
	HomeService homeService;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	//
	@RequestMapping("/test")
	private void Test(Model model, HttpServletRequest request) {
		logger.info("test1");
		try {
			Bridge.setVerbose(true);
			Bridge.init();

			File coreFile = new File("jni4net.n-0.8.8.0.dll");

			File dllFile = new File("MyJni.j4n.dll");


			Bridge.LoadAndRegisterAssemblyFrom(coreFile);
			Bridge.LoadAndRegisterAssemblyFrom(dllFile);


			MyJni myjni = new MyJni();
			String  response =  myjni.answer(" hi");
			System.out.println("dddddd:"+response);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));
		logger.info("test2");
	}

}













