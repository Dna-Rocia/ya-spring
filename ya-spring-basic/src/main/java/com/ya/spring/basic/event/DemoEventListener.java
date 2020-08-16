package com.ya.spring.basic.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//第二步，定义事件监听器
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {


    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我（bean-demoListener）接收到了bean-demoPublisher发布的消息："+msg);
    }
}
