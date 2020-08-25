package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 进行mock测试的控制器
 * @Author ROCIA
 * @Date 2020/8/25
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    //region
    @RequestMapping(value = "normal")
    public String  testPage (Model model){
        model.addAttribute("msg",this.testService.saySomething());
        return "page";
    }
    //endregion


    //region
    @RequestMapping(value = "testRest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String testRest(){
        return this.testService.saySomething();
    }
    //endregion

}
