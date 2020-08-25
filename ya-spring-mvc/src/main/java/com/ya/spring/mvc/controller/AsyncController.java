package com.ya.spring.mvc.controller;

import com.ya.spring.mvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/25
 */
@Controller
public class AsyncController {

    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){
        return this.pushService.getAsyncUpdate();
    }

}
