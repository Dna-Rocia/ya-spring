package com.ya.spring.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

        //web http 安全策略一
//        http.authorizeRequests()
//                //任何请求都进行验证
//                .anyRequest().authenticated()
//                .and()
//                // 登录
//                .formLogin()
//                .and()
//                .httpBasic();

//        //web http 安全策略二
        http.authorizeRequests()
                //任何请求都进行验证
                .anyRequest().authenticated()
                .and()
                // 登录
                .formLogin().loginPage("/myLogin.html").permitAll()
                .and()
                .csrf().disable();

//        //web http 安全策略三 告知前端登陆是否成功，有前端决定是否继续后续逻辑，而非服务端主动执行
//        http.authorizeRequests()
//                //任何请求都进行验证
//                .anyRequest().authenticated()
//                .and()
//                // 登录
//                .formLogin()
//                .loginPage("/myLogin.html")
//                .loginProcessingUrl("/login")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter writer = httpServletResponse.getWriter();
//                        writer.write("{\"errorCode\":\"0\",\"message\":\"欢迎登录！！\"}");
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        httpServletResponse.setStatus(401);
//                        PrintWriter writer = httpServletResponse.getWriter();
//                        writer.write("{\"errorCode\":\"401\",\"name\":"+e.getClass()+",\"message\":"+e.getMessage()+"}");
//                    }
//                })
//                .permitAll()
//                .and()
//                .csrf().disable();


    }
}
