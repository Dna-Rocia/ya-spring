package com.ya.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/api")
public class AppController {

    //region
    @RequestMapping("/hello")
    public String hello(){
        return "hello,App";
    }
    //endregion

}
