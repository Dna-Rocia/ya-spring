package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.model.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
@RestController //声明当前类是一个控制器，并且可忽略ResponseBody注解
@RequestMapping("/rest")
public class DemoRestController {

    //region
    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"}) //声明返回值是json
    public Demo getJson(Demo demo){
        return new Demo(demo.getId()+1,demo.getName()+"rest"); //对象会自动转json格式
    }
    //endregion


    //region
    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})//声明返回值是xml
    public Demo getXml(Demo demo){
        return new Demo(demo.getId()+1,demo.getName()+"rest");//对象会自动转xml
    }
    //endregion
}
