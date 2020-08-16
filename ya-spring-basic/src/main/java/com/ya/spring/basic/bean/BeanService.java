package com.ya.spring.basic.bean;

public class BeanService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanService(){
        super();
        System.out.println("初始化构造函数-BeanService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }

}
