package com.ya.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api")
public class UserController {

    //region
    @RequestMapping("/hello")
    public String hello(){
        return "hello,User";
    }
    //endregion


}
