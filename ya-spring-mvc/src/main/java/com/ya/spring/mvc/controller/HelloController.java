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


    //region 只做页面跳转，所以在实际业务中，当业务繁重庞大的时候，为了更好的集中管理，重写addViewControllers()即可
//    @RequestMapping("/index")
//    public String  index(){
//        return "index";
//    }
    //endregion


}
