package com.ya.spring.mvc.conf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description  替换 web.xml
    技术要点： 一. WebApplicationInitializer是spring用来配置servlet3.0+配置接口，替代了web.xml
             二. AnnotationConfigWebApplicationContext 注册配置类，并将其与ServletContext进行关联
             三. 注册springMvc的DispatcherServlet
 * @Author ROCIA
 * @Date 2020/8/24
 */
public class WebConfig implements WebApplicationInitializer {//一



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(SelfMvcConfig.class);
        webApplicationContext.setServletContext(servletContext); //二

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(webApplicationContext));//三
        // The URL patterns that this Servlet should be mapped to
        servlet.addMapping("/");
        //setLoadOnStartup 标记容器是否在启动的时候就加载这个servlet(实例化并调用其init()方法)。
        /*
            1)它的值必须是一个整数，表示servlet应该被载入的顺序
            2)当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；
            3)当值小于0或者没有指定时，则表示容器在该servlet被选择时才会去加载。
            4)正数的值越小，该servlet的优先级越高，应用启动时就越先加载。
            5)当值相同时，容器就会自己选择顺序来加载。
         */
        servlet.setLoadOnStartup(1);
        //开启异步支持，Servlet3.0+ 使用
        servlet.setAsyncSupported(true);


    }


}
