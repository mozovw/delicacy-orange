package com.delicacy.orange.springmvc.v1.controller;

import com.delicacy.orange.springmvc.v1.annotation.Autowired;
import com.delicacy.orange.springmvc.v1.annotation.Controller;
import com.delicacy.orange.springmvc.v1.annotation.RequestMapping;
import com.delicacy.orange.springmvc.v1.annotation.RequestParam;
import com.delicacy.orange.springmvc.v1.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Controller
@RequestMapping("/exam")
public class TestController {

    @Autowired("testServiceImpl")
    private TestService testService;


    @RequestMapping("/doTest")
    public void test(HttpServletRequest request, HttpServletResponse response,
                     @RequestParam("param") String param){
        String result = testService.test();
        try {
            response.getWriter().println("do service result:" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}