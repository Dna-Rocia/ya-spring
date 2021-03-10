package com.ya.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class AdminController {


    //region
    @RequestMapping("/hello")
    public String hello(){
        return "hello,Admin";
    }
    //endregion

}
