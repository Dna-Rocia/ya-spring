package com.ya.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Description sse技术
 *      本实例演示的是：每五秒钟像浏览器推送随机消息
 * @Author ROCIA
 * @Date 2020/8/25
 */
@Controller
public class SseController {

    /**
     * 这里指定的媒体输出类型为“text/event-stream,这是服务端支持SSE的支持。
     * @return
     */
    @RequestMapping(value = "/push",produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody String push(){
        Random random = new Random();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1, 2, 3"+random.nextInt()+"\n\n";
    }



}
