package com.ya.spring.basic;

import com.ya.spring.basic.conf.ELConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class YaSpringBasicApplication {

    public static void main(String[] args) {
//        SpringApplication.run(YaSpringBasicApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
//       DemoSingletonService singletonService1 =  context.getBean(DemoSingletonService.class);
//       DemoSingletonService singletonService2 = context.getBean(DemoSingletonService.class);
//
//       System.out.println("==:"+(singletonService1 == singletonService2));
//       System.out.println("equals:" +(singletonService1.equals(singletonService2)));
//
//        DemoPrototypeService prototypeService1 = context.getBean(DemoPrototypeService.class);
//        DemoPrototypeService prototypeService2 = context.getBean(DemoPrototypeService.class);
//
//        System.out.println("==:"+(prototypeService1 == prototypeService2));
//        System.out.println("equals:" +(prototypeService1.equals(prototypeService2)));


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig resourceService  = context.getBean(ELConfig.class);
        resourceService.outputResource();
        context.close();
    }

}
