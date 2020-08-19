package com.ya.spring.senior.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 实现BeanNameAware, ResourceLoaderAware，获取Bean名称和资源加载服务
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader loader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void  outputResult(){
        System.out.println("Bean 的名称为："+this.beanName);
        Resource resource  = this.loader.getResource("classpath:com/ya/spring/senior/aware/test.txt");
        try{
            System.out.println("ResourceLoader 加载文件内容为："+ IOUtils.toString(resource.getInputStream()));
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }



}
