package com.ya.spring.mvc.conf;


import com.ya.spring.mvc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @Description  静态资源的配置
 * @Author ROCIA
 * @Date 2020/8/24
 */
@EnableWebMvc //开启对spring mvc 的支持，如不存在此句，该配置无效
@Configuration  //声明配置类
@ComponentScan("com.ya.spring.mvc") //作用范围
public class MvcConfig implements WebMvcConfigurer {


    //============================静态资源===============================
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler：对外暴露的访问路径 ；addResourceLocations：文件放置目录
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }


    //==============================拦截器================================
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }



    //==============================视图解析器==============================
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

//========================页面跳转快捷管理=====================================
    /**
     * 处理页面跳转。
     * 优点：更好的集中管理，更简洁
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index"); //首页
        registry.addViewController("/fileupload").setViewName("/fileupload");//文件上传
        registry.addViewController("/converter").setViewName("/converter");

    }

//======================== 请求路径后缀的匹配处理================================
    /**
     *  路径匹配参数设置 /aa.bb .后边的参数值会被忽略 -> /aa
     *  因此加上该配置以后 /aa.bb
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);//因在当前版本中，useSuffixPatternMatch 该属性已默认设置为false.所以该方法已废弃
    }


//============================文件上传============================================

    /**
     * 文件上传适配设置
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(100000);//单位：byte  值为-1不限制长度
        return commonsMultipartResolver;
    }

//============================消息转换=============================================
    @Bean
    public MsgConverterConfig converter(){
        return new MsgConverterConfig();
    }
    /**
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }


}
