package com.ya.spring.senior.enable.e1;


import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

import java.lang.annotation.*;

/**
 * 第一类： 直接导入配置类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SchedulingConfiguration.class)  //用于导入配置类
@Documented
public @interface EnableScheduling {




}
