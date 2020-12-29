package com.ya.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/12/29
 */
@RestController
public class HelloController {



    //region
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    //endregion

}
