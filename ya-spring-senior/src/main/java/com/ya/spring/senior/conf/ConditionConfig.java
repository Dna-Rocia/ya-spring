package com.ya.spring.senior.conf;

import com.ya.spring.senior.condition.LinuxCondition;
import com.ya.spring.senior.condition.LinuxListService;
import com.ya.spring.senior.condition.WinListService;
import com.ya.spring.senior.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    //符合windows条件则实例化WinListService
    @Bean
    @Conditional(WindowsCondition.class)
    public WinListService windowsListService(){
        return new WinListService();
    }

    //符合linux条件则实例化linuxListService
    @Bean
    @Conditional(LinuxCondition.class)
    public LinuxListService linuxListService(){
        return new LinuxListService();
    }
}
