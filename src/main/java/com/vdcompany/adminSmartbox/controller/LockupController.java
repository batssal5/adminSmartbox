package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.vdcompany.adminSmartbox.bean.lookup.LookupVO;
import com.vdcompany.adminSmartbox.service.LookupService;
import com.vdcompany.adminSmartbox.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lookup")
public class LockupController {
	@Autowired
	LookupService lookupService;

	StrUtils strUtils = new StrUtils();

	Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping("/agencyJson")
	private void agencyJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {

		response.setContentType("text/html;charset=UTF-8");

		List<LookupVO> agencyVOList = lookupService.getLookupAgency();
		Map<String, Object> mapResp = new HashMap<>();
		mapResp.put("data", agencyVOList);

		response.getWriter().write(new Gson().toJson(agencyVOList));
	}

	@RequestMapping("/storeJson")
	private void storeJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {

		response.setContentType("text/html;charset=UTF-8");

		List<LookupVO> agencyVOList = lookupService.getLookupStoreInfo();
		Map<String, Object> mapResp = new HashMap<>();
		mapResp.put("data", agencyVOList);

		response.getWriter().write(new Gson().toJson(agencyVOList));
	}

}













