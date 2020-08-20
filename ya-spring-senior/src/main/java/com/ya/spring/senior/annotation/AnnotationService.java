package com.ya.spring.senior.annotation;

import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

    public void outputResult(){
        System.out.println("这里是测试元注解/组合注解的bean");
    }

}
