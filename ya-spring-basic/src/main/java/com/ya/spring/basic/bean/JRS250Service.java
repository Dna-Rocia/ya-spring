package com.ya.spring.basic.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JRS250Service {

    @PostConstruct/*执行顺序是在构造函数执行完成之后执行*/
    public void init(){
        System.out.println("JSR250-init-method");
    }

    public JRS250Service (){
        super();
        System.out.println("初始化构造函数-JSR250Service");
    }

    @PreDestroy /*bean容器销毁之前执行*/
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }

}
