package com.ya.spring.core.conf;

import com.ya.spring.core.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/26
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(Hello.class)
@ConditionalOnProperty(prefix = "hello" ,value = "enabled",matchIfMissing = true)
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    @ConditionalOnMissingBean(Hello.class)
    public Hello hello(){
        Hello hello = new Hello();
        hello.setMsg(this.helloProperties.getMsg());
        return hello;
    }





}
