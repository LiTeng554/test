package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class test01 {

    @RequestMapping("/123")
    public String test01_1(Map<String, Object> map){
        map.put("sting","语言");
        return "index";
    }
}
