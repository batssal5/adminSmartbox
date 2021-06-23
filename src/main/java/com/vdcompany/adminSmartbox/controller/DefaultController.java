package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreListVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.app.AppTutorialVO;
import com.vdcompany.adminSmartbox.bean.app.AppPolicyVO;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import com.vdcompany.adminSmartbox.bean.web.paging.PagingVO;
import com.vdcompany.adminSmartbox.service.*;
import com.vdcompany.adminSmartbox.utils.QueryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/default")
public class DefaultController {
	@Autowired
	AgencyService agencyService;
	@Autowired
	CategoryService cateService;
	@Autowired
	AppService appService;

	Logger logger = LoggerFactory.getLogger(this.getClass());


	String pageTitle = "기본설정";
	String menuListJson = "{\n" +
			"   \"leftMenuList\":[\n" +
			"      {\n" +
			"         \"menu_name\":\"약관관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"사용자APP\",\n" +
			"               \"link_url\":\"/default/userApp\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"관리자APP\",\n" +
			"               \"link_url\":\"/default/adminApp\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"사업자관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"사업자설정\",\n" +
			"               \"link_url\":\"/default/agencyMng\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"지점관리\",\n" +
			"               \"link_url\":\"/default/storeMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"어플관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"버전설정\",\n" +
			"               \"link_url\":\"/default/appVersion\"\n" +
			"            },\n" +
			"            {\n" +
			"               \"menu_name\":\"제한설정\",\n" +
			"               \"link_url\":\"/default/appAuth\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"환불정책\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"환불설정\",\n" +
			"               \"link_url\":\"/default/refundMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      },\n" +
			"      {\n" +
			"         \"menu_name\":\"결제수단관리\",\n" +
			"         \"menu_icon\":\"pe-7s-display2\",\n" +
			"         \"link_url\":\"#\",\n" +
			"         \"leftMenuSub\":[\n" +
			"            {\n" +
			"               \"menu_name\":\"카드설정\",\n" +
			"               \"link_url\":\"/default/paymentCardMng\"\n" +
			"            }\n" +
			"         ]\n" +
			"      }\n" +
			"   ]\n" +
			"}";
	//

	@RequestMapping("/userApp")
	private ModelAndView userApp(Model model, HttpServletRequest request) {
		String url = "/default/userApp";
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

	@RequestMapping("/adminApp")
	private ModelAndView adminApp(Model model, HttpServletRequest request) {
		String url = "/default/adminApp";
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

    @RequestMapping("/ajax_getApp")
    private void ajax_adminApp(HttpServletResponse response, HttpServletRequest request, AppPolicyVO policy) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        policy.setApp_type(Integer.parseInt(request.getParameter("appType")));

        List<AppPolicyVO> policyList = appService.getPolicyList(policy);
        System.out.println("policyList :" + policyList);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().print(mapper.writeValueAsString(policyList));
    }

    @RequestMapping("/ajax_postApp")
    private void ajax_post_adminApp(HttpServletRequest request, HttpServletResponse response, AppPolicyVO policy) {
        response.setContentType("text/html;charset=UTF-8");


        logger.info("terms:" + request.getParameter("terms"));

        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();

        System.out.println(request.getParameter("location"));

        if (request.getParameter("terms") != null) {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("catagory", "이용약관");
            if (request.getParameter("location").equals("/default/adminApp")) {
                tempMap.put("a_context", request.getParameter("terms"));
            } else {
                tempMap.put("c_context", request.getParameter("terms"));
            }
            listMap.add(tempMap);
        }

        if (request.getParameter("policy") != null) {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("catagory", "개인정보처리방침");
            if (request.getParameter("location").equals("/default/adminApp")) {
                tempMap.put("a_context", request.getParameter("policy"));
            } else {
                tempMap.put("c_context", request.getParameter("policy"));
            }
            listMap.add(tempMap);
        }

        if (request.getParameter("subinfo") != null) {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("catagory", "가입안내");
            if (request.getParameter("location").equals("/default/adminApp")) {
                tempMap.put("a_context", request.getParameter("subinfo"));
            } else {
                tempMap.put("c_context", request.getParameter("subinfo"));
            }
            listMap.add(tempMap);
        }

        if (request.getParameter("secession") != null) {
            Map<String, String> tempMap = new HashMap<>();
            tempMap.put("catagory", "탈퇴안내");
            if (request.getParameter("location").equals("/default/adminApp")) {
                tempMap.put("a_context", request.getParameter("secession"));
            } else {
                tempMap.put("c_context", request.getParameter("secession"));
            }
            listMap.add(tempMap);
        }

        System.out.println("listMap : " + listMap);

        policy.setApp_type(Integer.parseInt(request.getParameter("appType")));
        policy.setListMap(listMap);
        System.out.println(policy);

        for (Object obj : policy.getListMap()) {
            System.out.println(obj);
        }

        appService.postPolicyList(policy);

    }

    @RequestMapping("/ajax_uploadImg")
    private void ajax_postImg(MultipartHttpServletRequest req, HttpServletResponse response, AppTutorialVO appTutorial) throws IOException {
        String url = "/default/adminApp";
        ModelAndView mav = new ModelAndView(url);
        String path = "C:/Vd/WebProjects/SmartBoxAdmin/src/main/resources/static/tutorial";
        File Folder = new File(path);
        List<String> filePath = new ArrayList<>();
        List<MultipartFile> mtfList = new ArrayList<>();

//        List<Map<String, String>> listMap = new ArrayList<>();
//        List<String> sortList = new ArrayList<>();

        try {
            MultiValueMap<String, MultipartFile> files = req.getMultiFileMap();
            System.out.println("files: " + files);

            for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) {
                List<MultipartFile> fileList = entry.getValue();
//                String sort = entry.getKey();
//                sortList.add(sort);
                System.out.println("entry :"+entry);
                System.out.println("fileList: " + fileList);
//                System.out.println("sort : "+sort);

                for (MultipartFile file : fileList) {
                    if (file.isEmpty()) continue;
                    mtfList.add(file);
                }
            }

            if (mtfList.size() > 0) {
                if (!Folder.exists()) {
                    try{
                        Folder.mkdir();
                        System.out.println("폴더생성");
                    }
                    catch(Exception e){
                        e.getStackTrace();
                    }
                }
                for (MultipartFile file : mtfList) {
                    file.transferTo(new File(path+ "/" + file.getOriginalFilename()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mtfList.size(); i++) {
            System.out.println(path+ "/" + mtfList.get(i).getOriginalFilename());
            System.out.println(mtfList.get(i).getSize());
            filePath.add("/tutorial/" + mtfList.get(i).getOriginalFilename());
            System.out.println("filePath : " + filePath);
        }

        response.getWriter().write(new Gson().toJson(filePath));

//        for (int i = 0; i < filePath.size(); i++) {
//            Map<String, String> temp = new HashMap<>();
//            temp.put("sort",sortList.get(i));
//            temp.put("src",filePath.get(i));
//            System.out.println("temp : " + temp);
//            listMap.add(temp);
//        }
//
//        appTutorial.setListMap(listMap);
//        appTutorialService.putTutorial(appTutorial);

    }


    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }

    @RequestMapping("/ajax_postImg")
    private void ajax_postImg(HttpServletRequest request, HttpServletResponse response){

        String json = request.getParameter("jsonData");

        List<AppTutorialVO> list = stringToArray(json, AppTutorialVO[].class);
        System.out.println("list : "+list);

        appService.postTutorialList(list);

    }



	@RequestMapping("/agencyMng")
	private ModelAndView agencyMng(Model model, HttpServletRequest request) {
		String page_url = "/default/agencyMng";
		ModelAndView mav = new ModelAndView(page_url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		return mav;
	}


	@RequestMapping("/agencyMng/json")
	private void agencyMngJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
		QueryUtils queryUtils = new QueryUtils();
		String WHERE = "";
		PagingVO pagingVO = new PagingVO();
		pagingVO.setType(request.getParameter("type"));
		boolean requireTotalCount = false;
		if(request.getParameter("skip")!=null) {
			logger.info("skip---------------");
			pagingVO.setSkip(Integer.parseInt(request.getParameter("skip")));
		}
		if(request.getParameter("take")!=null) {
			logger.info("take---------------");
			pagingVO.setTake(Integer.parseInt(request.getParameter("take")));
		}
		if(request.getParameter("requireTotalCount")!=null && request.getParameter("requireTotalCount").equals("true")) {
			logger.info("requireTotalCount---------------");
			requireTotalCount = true;
			pagingVO.setRequireTotalCount(request.getParameter("requireTotalCount"));
		}
		if(request.getParameter("filter")!=null && !request.getParameter("filter").equals("")) {
			String filterStr = request.getParameter("filter");
			logger.info("filter---------------:"+filterStr);
			List<Object> fList = new Gson().fromJson(filterStr, List.class);
			WHERE = queryUtils.whereFilter(fList);
			logger.info("WHERE:"+WHERE);
			pagingVO.setFilter(WHERE);
		}

		logger.info("crudType : " + pagingVO.getType());
		Map<String, Object> mapResp = new HashMap<>();
		response.setContentType("text/html;charset=UTF-8");
		AgencyVO agencyVO  = new AgencyVO();
		switch (pagingVO.getType()){
			case "put":
				String putDataString = request.getParameter("values");
				logger.info("putDataString:"+putDataString);
				agencyVO  =  new Gson().fromJson(putDataString, AgencyVO.class);
				logger.info("agencyVO:"+new Gson().toJson(agencyVO));
				List<AgencyVO> putRst = new ArrayList<>();
				putRst = agencyService.putAgencyInfo(agencyVO);
				if(putRst.size()>0) {
					response.getWriter().write(new Gson().toJson(putRst.get(0)));
				}
				break;
			case "get":
				List<AgencyVO> agencyInfoList = agencyService.getAgencyInfo(pagingVO);

				//logger.info("xxxxxxxxxxxxxxxxxxxxx:"+new Gson().toJson(agencyInfoList));
				mapResp.put("data", agencyInfoList);
				if(requireTotalCount){
					PagingVO pagingCountVO = new PagingVO();
					if(!WHERE.equals("")){
						pagingCountVO.setFilter(WHERE);
					}
					List<AgencyVO> agencyInfoCount = agencyService.getAgencyInfo(pagingCountVO);
					mapResp.put("totalCount", agencyInfoCount.size());
				}
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
			case "post":
				String postKey = request.getParameter("key");
				String postDataString = request.getParameter("values");
				logger.info("postKey:"+postKey);
				logger.info("postDataString:"+postDataString);
				agencyVO  =  new Gson().fromJson(postDataString, AgencyVO.class);
				agencyVO.setIdx(Integer.parseInt(postKey));
				logger.info("agencyVO:"+new Gson().toJson(agencyVO));
				List<AgencyVO> postRst = new ArrayList<>();
				if(postKey!=null && !postKey.equals("")) {
					postRst = agencyService.postAgencyInfo(agencyVO);
				}
				if(postRst.size()>0) {
					response.getWriter().write(new Gson().toJson(postRst.get(0)));
				}
				break;
			case "delete":
				String deleteKey = request.getParameter("key");
				logger.info("deleteKey:"+deleteKey);
				agencyVO.setIdx(Integer.parseInt(deleteKey));
				int delBoxRst = agencyService.delAgencyInfo(agencyVO);
				logger.info("delBoxRst:"+delBoxRst);

				break;
		}
	}

	@RequestMapping("/storeMng")
	private ModelAndView storeMng(Model model, HttpServletRequest request) {
		String url = "/default/storeMng";
		ModelAndView mav = new ModelAndView(url);

		Map<String, Object> pageinfo = new HashMap<>();
		pageinfo.put("pageTitle", pageTitle);
		pageinfo.put("date", LocalDateTime.now());

		LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
		//logger.info("json:"+new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

		mav.addObject("pageInfo", pageinfo);
		mav.addObject("leftMenuInfo", leftMenuListVO);
		return mav;
	}
	@RequestMapping("/storeMng/json")
	private void storeMngJson( HttpServletResponse response, HttpServletRequest request) throws IOException  {
		QueryUtils queryUtils = new QueryUtils();
		String WHERE = "";
		PagingVO pagingVO = new PagingVO();
		pagingVO.setType(request.getParameter("type"));
		boolean requireTotalCount = false;
		if(request.getParameter("skip")!=null) {
			logger.info("skip---------------");
			pagingVO.setSkip(Integer.parseInt(request.getParameter("skip")));
		}
		if(request.getParameter("take")!=null) {
			logger.info("take---------------");
			pagingVO.setTake(Integer.parseInt(request.getParameter("take")));
		}
		if(request.getParameter("requireTotalCount")!=null && request.getParameter("requireTotalCount").equals("true")) {
			logger.info("requireTotalCount---------------");
			requireTotalCount = true;
			pagingVO.setRequireTotalCount(request.getParameter("requireTotalCount"));
		}
		if(request.getParameter("filter")!=null && !request.getParameter("filter").equals("")) {
			String filterStr = request.getParameter("filter");
			logger.info("filter---------------:"+filterStr);
			List<Object> fList = new Gson().fromJson(filterStr, List.class);
			WHERE = queryUtils.whereFilter(fList);
			logger.info("WHERE:"+WHERE);
			pagingVO.setFilter(WHERE);

		}

		logger.info("crudType : " + pagingVO.getType());
		Map<String, Object> mapResp = new HashMap<>();
		response.setContentType("text/html;charset=UTF-8");
		AgencyVO agencyVO  = new AgencyVO();
		switch (pagingVO.getType()){
			case "put":
				String putDataString = request.getParameter("values");
				logger.info("putDataString:"+putDataString);
				agencyVO  =  new Gson().fromJson(putDataString, AgencyVO.class);
				logger.info("agencyVO:"+new Gson().toJson(agencyVO));
				List<AgencyVO> putRst = new ArrayList<>();
				putRst = agencyService.putAgencyStoreInfo(agencyVO);
				if(putRst.size()>0) {
					response.getWriter().write(new Gson().toJson(putRst.get(0)));
				}
				break;
			case "get":
				List<AgencyVO> agencyInfoList = agencyService.getAgencyStoreInfo(pagingVO);

				//logger.info("xxxxxxxxxxxxxxxxxxxxx:"+new Gson().toJson(agencyInfoList));
				mapResp.put("data", agencyInfoList);
				if(requireTotalCount){
					PagingVO pagingCountVO = new PagingVO();
					if(!WHERE.equals("")){
						pagingCountVO.setFilter(WHERE);
					}
					List<AgencyVO> agencyInfoCount = agencyService.getAgencyStoreInfo(pagingCountVO);
					mapResp.put("totalCount", agencyInfoCount.size());
				}
				response.getWriter().write(new Gson().toJson(mapResp));
				break;
			case "post":
				String postKey = request.getParameter("key");
				String postDataString = request.getParameter("values");
				logger.info("postKey:"+postKey);
				logger.info("postDataString:"+postDataString);
				agencyVO  =  new Gson().fromJson(postDataString, AgencyVO.class);
				agencyVO.setStore_idx(Integer.parseInt(postKey));
				logger.info("agencyVO:"+new Gson().toJson(agencyVO));
				List<AgencyVO> postRst = new ArrayList<>();
				if(postKey!=null && !postKey.equals("")) {
					postRst = agencyService.postAgencyStoreInfo(agencyVO);
				}
				if(postRst.size()>0) {
					response.getWriter().write(new Gson().toJson(postRst.get(0)));
				}
				break;
			case "delete":
				String deleteKey = request.getParameter("key");
				logger.info("deleteKey:"+deleteKey);
				agencyVO.setStore_idx(Integer.parseInt(deleteKey));
				int delBoxRst = agencyService.delAgencyStoreInfo(agencyVO);
				logger.info("delBoxRst:"+delBoxRst);

				break;
		}
	}

	@RequestMapping("/appVersion")
	private ModelAndView appVersion(Model model, HttpServletRequest request) {
		String url = "/default/appVersion";
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

	@RequestMapping("/appAuth")
	private ModelAndView appAuth(Model model, HttpServletRequest request) {
		String url = "/default/appAuth";
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

	@RequestMapping("/refundMng")
	private ModelAndView refundMng(Model model, HttpServletRequest request) {
		String url = "/default/refundMng";
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

	@RequestMapping("/paymentCardMng")
	private ModelAndView paymentCardMng(Model model, HttpServletRequest request) {
		String url = "/default/paymentCardMng";
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













