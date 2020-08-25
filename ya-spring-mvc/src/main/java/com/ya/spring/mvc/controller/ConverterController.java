package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.model.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 参数按照自定义的media类型进行转化
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert",produces = {"application/x-ya"})
    public @ResponseBody Demo converter(@RequestBody Demo demo){
        return demo;
    }


}
