package com.ya.spring.mvc.conf;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description
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
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }


}
