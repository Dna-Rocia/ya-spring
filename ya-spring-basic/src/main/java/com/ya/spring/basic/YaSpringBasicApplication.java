package com.ya.spring.basic;

import com.ya.spring.basic.bean.BeanService;
import com.ya.spring.basic.bean.JRS250Service;
import com.ya.spring.basic.conf.*;
import com.ya.spring.basic.event.DemoPublisher;
import com.ya.spring.basic.profile.DemoBean;
import com.ya.spring.basic.scope.DemoPrototypeService;
import com.ya.spring.basic.scope.DemoSingletonService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class YaSpringBasicApplication {

    public static void main(String[] args) {
//        SpringApplication.run(YaSpringBasicApplication.class, args);
        YaSpringBasicApplication yaSpringBasicApplication = new YaSpringBasicApplication();
//        yaSpringBasicApplication.bean();
//        yaSpringBasicApplication.profile();
        yaSpringBasicApplication.event();

    }

    public void event(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("Hello,application event");
        context.close();
    }



    public void  profile(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }


    public void  bean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanJrsConfig.class);
        BeanService beanService = context.getBean(BeanService.class);
        JRS250Service jrs250Service = context.getBean(JRS250Service.class);
        context.close();
    }



    public void el(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig resourceService  = context.getBean(ELConfig.class);
        resourceService.outputResource();
        context.close();
    }



    public void scope(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
       DemoSingletonService singletonService1 =  context.getBean(DemoSingletonService.class);
       DemoSingletonService singletonService2 = context.getBean(DemoSingletonService.class);

       System.out.println("==:"+(singletonService1 == singletonService2));
       System.out.println("equals:" +(singletonService1.equals(singletonService2)));

        DemoPrototypeService prototypeService1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService prototypeService2 = context.getBean(DemoPrototypeService.class);

        System.out.println("==:"+(prototypeService1 == prototypeService2));
        System.out.println("equals:" +(prototypeService1.equals(prototypeService2)));
    }



}
