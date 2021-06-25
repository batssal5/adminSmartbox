package com.vdcompany.adminSmartbox.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vdcompany.adminSmartbox.bean.web.menu.LeftMenuListVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {


    @RequestMapping("/")
    private ModelAndView userApp(Model model, HttpServletRequest request) {
        String url = "/login/login";
        ModelAndView mav = new ModelAndView(url);

        Map<String, Object> pageinfo = new HashMap<>();
        pageinfo.put("date", LocalDateTime.now());

        mav.addObject("pageInfo", pageinfo);

        return mav;
    }

}
