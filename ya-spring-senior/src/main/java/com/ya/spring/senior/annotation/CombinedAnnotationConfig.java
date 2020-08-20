package com.ya.spring.senior.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 组合注解
 * Target 说明了Annotation所修饰的对象范围  Type --用于描述类、接口(包括注解类型) 或enum声明 Class, interface (including annotation type), or enum declaration
 *
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //组合注解一
@ComponentScan //组合注解二
public @interface CombinedAnnotationConfig {

    String[] value() default {};
}
