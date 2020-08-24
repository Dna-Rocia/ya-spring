package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.model.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, Demo demo){
        throw new IllegalArgumentException("非常抱歉，传入参数异常/来自 @ModelAttribute:"+msg);
    }


}
