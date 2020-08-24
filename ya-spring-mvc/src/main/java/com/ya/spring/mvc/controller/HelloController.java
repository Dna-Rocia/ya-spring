package com.ya.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Controller
public class HelloController {


    //region
    @RequestMapping("/index")
    public String  index(){
        return "index";
    }
    //endregion


}
