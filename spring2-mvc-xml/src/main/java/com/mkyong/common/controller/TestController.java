package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


// This is hello world of mvc annotation-----controller
@Controller
@RequestMapping("/test")
public class TestController {
    
    @ResponseBody
    @RequestMapping(value = "/test.htm")
    public String test() {
        return "This is a test";
    }
    @ResponseBody
    @RequestMapping(value = "/login")
    //
    public ModelAndView login() {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}

//json的数据解析