package com.ya.spring.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class WebSecurityConfig1  extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(WebSecurityConfig1.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

//        web http 安全策略一
        http.authorizeRequests()
                //任何请求都进行验证
                .anyRequest().authenticated()
                .and()
                // 登录
                .formLogin()
                .and()
                .httpBasic();

    }
}
