package com.ya.spring.senior.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.ya.spring.senior.scheduled")
@EnableScheduling //开启针对计划任务的支持
public class ScheduledConfig {



}
