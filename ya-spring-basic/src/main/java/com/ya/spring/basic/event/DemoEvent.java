package com.ya.spring.basic.event;

import org.springframework.context.ApplicationEvent;

/**
 * spring 事件遵循的流程：
    ① 自定义事件，继承ApplicationEvent
    ② 定义事件监听器，实现ApplicationListener
    ③ 使用容器发布事件
 */
//第一步，自定义事件
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
