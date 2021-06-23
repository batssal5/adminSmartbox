package com.vdcompany.adminSmartbox.controller;

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
import com.vdcompany.adminSmartbox.service.*;
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
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

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
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

        mav.addObject("pageInfo", pageinfo);
        mav.addObject("leftMenuInfo", leftMenuListVO);

        return mav;
    }

    @RequestMapping("/ajax_getApp")
    private void ajax_adminApp(HttpServletResponse response, HttpServletRequest request, AppPolicyVO policy) throws JsonProcessingException, IOException {
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
        String url = "/default/agencyMng";
        ModelAndView mav = new ModelAndView(url);

        Map<String, Object> pageinfo = new HashMap<>();
        pageinfo.put("pageTitle", pageTitle);
        pageinfo.put("date", LocalDateTime.now());

        LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

        mav.addObject("pageInfo", pageinfo);
        mav.addObject("leftMenuInfo", leftMenuListVO);

        int agency_idx = 0;
        if (request.getParameter("agency_idx") != null) {
            agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
        }

        // agency_idx 가 0일경우 전체 지점 리스트가 나온다
        List<AgencyStoreVO> storeList = agencyService.getStoreList(agency_idx);
        model.addAttribute("storeList", storeList);

        List<AgencyVO> agencyList = agencyService.getAgencyList();
        model.addAttribute("agencyList", agencyList);

        return mav;
    }

    @RequestMapping("/appVersion")
    private ModelAndView appVersion(Model model, HttpServletRequest request) {
        String url = "/default/appVersion";
        ModelAndView mav = new ModelAndView(url);

        Map<String, Object> pageinfo = new HashMap<>();
        pageinfo.put("pageTitle", pageTitle);
        pageinfo.put("date", LocalDateTime.now());

        LeftMenuListVO leftMenuListVO = new Gson().fromJson(menuListJson, LeftMenuListVO.class);
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

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
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

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
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

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
        logger.info("json:" + new GsonBuilder().setPrettyPrinting().create().toJson(leftMenuListVO));

        mav.addObject("pageInfo", pageinfo);
        mav.addObject("leftMenuInfo", leftMenuListVO);

        return mav;
    }

    @RequestMapping("/agencyList")
    private String agencyList(Model model, HttpServletRequest request) {

        System.out.println("agency_idx : " + request.getParameter("agency_idx"));

        int agency_idx = 0;
        if (request.getParameter("agency_idx") != null) {
            agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
        }

        // agency_idx 가 0일경우 전체 지점 리스트가 나온다
        List<AgencyStoreVO> storeList = agencyService.getStoreList(agency_idx);
        model.addAttribute("storeList", storeList);

        List<AgencyVO> agencyList = agencyService.getAgencyList();
        model.addAttribute("agencyList", agencyList);

        List<CategoryVO> cateList = cateService.getCateList("STOAR");
        model.addAttribute("cateList", cateList);

        return "/default/agencyList";
    }

    @RequestMapping("/ajax_store")
    private void ajax_storeList(HttpServletResponse response, Model model, HttpServletRequest request) throws JsonProcessingException, IOException {


        response.setContentType("text/html;charset=UTF-8");


        String temp = request.getParameter("agency_idx");
        if (temp != null) {

            List<AgencyStoreVO> storeList = new ArrayList<>();
            storeList = agencyService.getStoreList(Integer.parseInt(temp));

            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().print(mapper.writeValueAsString(storeList));
        }

    }

    @RequestMapping("/ajax_search")
    private void ajax_search(HttpServletResponse response, HttpServletRequest request, AgencySearchVO search) throws JsonProcessingException, IOException {

        int agency_idx = 0;
        if (request.getParameter("agency_idx") != null) {
            agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
        }
        int store_idx = 0;
        if (request.getParameter("store_idx") != null) {
            store_idx = Integer.parseInt(request.getParameter("store_idx"));
        }

        search.setAgc_idx(agency_idx);
        search.setIdx(store_idx);
        System.out.println("search : " + search);

        List<AgencyStoreVO> storeList = new ArrayList<>();
        storeList = agencyService.getSearchStoreList(search);
        System.out.println("result : " + storeList);

        response.setContentType("text/html;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().print(mapper.writeValueAsString(storeList));

    }


    @RequestMapping("/agencyAdd")
    private String agencyAdd(Model model, HttpServletRequest request) {

        List<CategoryVO> cateList = cateService.getCateList("STOAR");
        model.addAttribute("cateList", cateList);

        return "/default/agencyAdd";
    }


    @RequestMapping("/ajax_Add")
    private void ajax_AgencyAdd(HttpServletResponse response, HttpServletRequest request, AgencyVO agency, AgencyStoreListVO storeList) throws JsonProcessingException, IOException {

        System.out.println("agency : " + agency);
        System.out.println("storeList : " + storeList);

        response.setContentType("text/html;charset=UTF-8");

        // 지점데이터중 행삭제로인한 빈값데이터 필터링 (지점사업자번호가 있는지 없는지로 판단)
        List<AgencyStoreVO> list = new ArrayList<AgencyStoreVO>();
        List<AgencyStoreVO> temp = storeList.getList();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getStore_num() != null && !temp.get(i).getStore_num().equals("")) {
                list.add(temp.get(i));
            }
        }
        storeList.setList(list);

        // 유효성체크
        String errorAgency = validAgency(agency);
        if (!errorAgency.equals("")) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"" + errorAgency + "\"}");
            return;
        }
        String errorStore = validStore(list);
        if (!errorStore.equals("")) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"" + errorStore + "\"}");
            return;
        }

        // 본사먼저 등록
        int agc_idx = agencyService.insertAgency(agency);
        System.out.println("agc_idx : " + agc_idx);

        if (agc_idx == 0) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"본사 DB등록중 오류가 생겼습니다.\"}");
            return;
        }

        // List에 agc_idx 추가 및 빈값데이터 필터링
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAgc_idx(agc_idx);
        }
        // 지점등록
        int ret = agencyService.insertStoreList(list);

        if (ret > 0) {
            response.getWriter().print("{\"ret\":0 }");
        } else {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"지점 DB등록중 오류가 생겼습니다.\"}");
        }

    }


    private String validAgency(AgencyVO agency) {

        String errorLog = "";

        if (agency.getCompany_name() != null && agency.getCompany_name() == "") {
            errorLog = "본사명을 입력하세요.";
        } else if (agency.getCompany_num() != null && agency.getCompany_num() == "") {
            errorLog = "본사사업자번호를 입력하세요.";
        } else if (agency.getCommission_pg() != null && agency.getCommission_pg() == "") {
            errorLog = "PG수수료를 입력하세요.";
        } else if (agency.getCommission_vd() != null && agency.getCommission_vd() == "") {
            errorLog = "VD수수료를 입력하세요.";
        } else if (agency.getRep_nm() != null && agency.getRep_nm() == "") {
            errorLog = "담당자를 입력하세요.";
        } else if (agency.getRep_email() != null && agency.getRep_email() == "") {
            errorLog = "이메일을 입력하세요.";
        } else if (agency.getRep_mobile() != null && agency.getRep_mobile() == "") {
            errorLog = "휴대전화를 입력하세요.";
        } else if (agency.getRep_tel() != null && agency.getRep_tel() == "") {
            errorLog = "일반전화를 입력하세요.";
        } else if (agency.getZipcode() != null && agency.getZipcode() == "") {
            errorLog = "주소를 입력하세요.";
        } else if (agency.getAddress() != null && agency.getAddress() == "") {
            errorLog = "주소를 입력하세요.";
        } else if (agency.getAddr_detail() != null && agency.getAddr_detail() == "") {
            errorLog = "주소를 입력하세요.";
        }

        return errorLog;
    }

    private String validStore(List<AgencyStoreVO> list) {

        String errorLog = "";

        for (int i = 0; i < list.size(); i++) {
            AgencyStoreVO store = list.get(i);

            if (store.getStore_name() != null && store.getStore_name() == "") {
                errorLog = (i + 1) + "번째 지점의" + " 지점명을 입력하세요.";
            } else if (store.getStore_num() != null && store.getStore_num() == "") {
                errorLog = (i + 1) + "번째 지점의" + " 지점사업자번호를 입력하세요.";
            } else if (store.getCate() == 0) {
                errorLog = (i + 1) + "번째 지점의" + " 상권을 선택하세요." + store.getCate();
            } else if (store.getPg_comm() != null && store.getPg_comm() == "") {
                errorLog = (i + 1) + "번째 지점의" + " PG수수료를 입력하세요.";
            } else if (store.getVd_comm() != null && store.getVd_comm() == "") {
                errorLog = (i + 1) + "번째 지점의" + " VD수수료를 입력하세요.";
            }
            if (errorLog != "") {
                break;
            }
        }

        if (list.size() == 0) {
            errorLog = "지점데이터가 없습니다.";
        }

        return errorLog;
    }

    @RequestMapping("/agencyModify")
    private String agencyModify(Model model, HttpServletRequest request) {

        int idx = Integer.parseInt(request.getParameter("idx"));
        AgencyVO agency = agencyService.getAgencyDetail(idx);
        model.addAttribute("agency", agency);

        List<CategoryVO> cateList = cateService.getCateList("STOAR");
        model.addAttribute("cateList", cateList);

        List<AgencyStoreVO> storeList = agencyService.getStoreList(idx);
        for (AgencyStoreVO store : storeList) {
            for (CategoryVO cate : cateList) {
                if (store.getCate() == cate.getCate_vu()) {
//					store.setCate_name(cate.getCate_nm());
                    break;
                }
            }
        }
        model.addAttribute("storeList", storeList);
        System.out.println("storeList : " + storeList);

        return "/default/agencyModify";
    }

    @RequestMapping("/ajax_Update")
    private void ajax_Update(HttpServletResponse response, HttpServletRequest request, AgencyVO agency, AgencyStoreListVO storeList) throws JsonProcessingException, IOException {

        System.out.println("agency : " + agency);
        System.out.println("storeList : " + storeList);

        response.setContentType("text/html;charset=UTF-8");

        // 지점데이터중 행삭제로인한 빈값데이터 필터링 (지점사업자번호가 있는지 없는지로 판단)
        List<AgencyStoreVO> list = new ArrayList<AgencyStoreVO>();
        List<AgencyStoreVO> temp = storeList.getList();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getStore_num() != null && !temp.get(i).getStore_num().equals("")) {
                list.add(temp.get(i));
            }
        }
        storeList.setList(list);

        // 유효성체크
        String errorAgency = validAgency(agency);
        if (!errorAgency.equals("")) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"" + errorAgency + "\"}");
            return;
        }
        String errorStore = validStore(list);
        if (!errorStore.equals("")) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"" + errorStore + "\"}");
            return;
        }

        // 본사먼저 업데이트
        int agc_idx = agencyService.updateAgency(agency);
        if (agc_idx == 0) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\"본사 DB등록중 오류가 생겼습니다.\"}");
            return;
        }

        // List에 idx값이 있는경우 update 처리
        // idx값이 없는경우 insert 처리
        List<AgencyStoreVO> updateList = new ArrayList<AgencyStoreVO>();
        List<AgencyStoreVO> insertList = new ArrayList<AgencyStoreVO>();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setAgc_idx(agc_idx);
            if (list.get(i).getIdx() > 0) {
                updateList.add(list.get(i));
            } else {
                insertList.add(list.get(i));
            }
        }

        int ret = 0;
        System.out.println("updateList : " + updateList.size());
        if (updateList.size() > 0) {
            ret = agencyService.updateStoreList(updateList);
        }
        System.out.println("insertList : " + insertList.size());

        if (insertList.size() > 0) {
            ret = agencyService.insertStoreList(insertList);
        }


        System.out.println("updateList : " + updateList.size());
        System.out.println("insertList : " + insertList.size());


        if (ret == 0) {
            response.getWriter().print("{\"ret\":-1  ,\"error\":\" DB등록중 오류가 생겼습니다.\"}");
        } else {
            response.getWriter().print("{\"ret\":0 }");
        }

//		// 지점등록
//		int ret = agencyService.insertStoreList(list);
//
//		if (ret > 0) {
//			response.getWriter().print("{\"ret\":0 }");
//		} else {
//			response.getWriter().print("{\"ret\":-1  ,\"error\":\"지점 DB등록중 오류가 생겼습니다.\"}");
//		}

    }
}













