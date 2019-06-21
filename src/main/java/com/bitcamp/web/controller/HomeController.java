package com.bitcamp.web.controller;

import com.bitcamp.web.common.util.Printer;
import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @Autowired CustomerService customerService;
    @Autowired Printer p;
    @RequestMapping("/") //application.properties 의 prefix에 맵핑
    public String index() {
        p.accept("루트 URL 경로로 들어왔음");
        int count = customerService.countAll();
        p.accept("고객의 총인원 : " +count);
//        System.out.println("고객의 총인원 : " +count);
        return "index"; //application.properties 의 suffix에 맵핑
    } 
    
}