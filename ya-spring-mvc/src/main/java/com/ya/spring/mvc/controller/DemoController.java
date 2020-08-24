package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.model.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Controller  //声明控制器
@RequestMapping("/anno") //定义当前控制器公用根路径
public class DemoController {

    @RequestMapping(produces = "text/plain;charset=utf-8") //如未声明mapping，就默认使用根路径
    public @ResponseBody  String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=utf-8") //参数在请求路径上
    public @ResponseBody  String pathVar(HttpServletRequest request, @PathVariable String str){
        return "url:"+request.getRequestURL()+" can access, path var-str:"+str;
    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=utf-8")//参数在请求体中，单个字段
    public @ResponseBody  String requestParam(HttpServletRequest request,  Long id){
        return "url:"+request.getRequestURL()+" can access, request body param-id:"+id;
    }

    @RequestMapping(value = "/demo",produces = "text/plain;charset=utf-8")//参数在请求体中，是一个对象
    @ResponseBody
    public  String passObj(HttpServletRequest request,  Demo demo){
        return "url:"+request.getRequestURL()+" can access, Demo Object info  id:"+demo.getId() +", name:"+demo.getName();
    }

    @RequestMapping(value = {"/remove","/remove2"},produces = "text/plain;charset=utf-8")
    public @ResponseBody  String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }



}
