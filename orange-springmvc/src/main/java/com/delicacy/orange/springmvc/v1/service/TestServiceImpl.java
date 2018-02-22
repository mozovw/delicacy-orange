package com.delicacy.orange.springmvc.v1.service;

import com.delicacy.orange.springmvc.v1.annotation.Autowired;

public class TestServiceImpl implements TestService {


    @Override
    public String test() {
        return "method test do success!";
    }

}