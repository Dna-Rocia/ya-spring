package com.ya.spring.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @Description 该配置类是用于映射路径和实际页面的位置
 * @Author ROCIA
 * @Date 2020/8/24
 */
@Configuration
@EnableWebMvc // EnableWebMvc开启一些默认的配置
@ComponentScan("com.ya.spring.mvc")
public class SelfMvcConfig {


    /**
     * springMVC 中有一个很核心的接口，ViewResolver,只要重写该接口的resolveViewName()，
     * 因为该方法返回的view职责是使用model,request，response对象，进行渲染视图（不一定是html，也可能是json,xml，pdf）返回浏览器
     * @return 视图解析器
     */

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//      真实页面的路径前缀
        viewResolver.setPrefix("/WEB-INF/classes/views/");
//      页面的后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }



}
