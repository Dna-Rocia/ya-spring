package com.ya.spring.basic.conf;

import com.ya.spring.basic.bean.BeanService;
import com.ya.spring.basic.bean.JRS250Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ya.spring.basic.bean")
public class BeanJrsConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanService beanService(){
        return new BeanService();
    }

    @Bean
    JRS250Service jrs250Service(){
        return new JRS250Service();
    }
}
