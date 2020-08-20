package com.ya.spring.senior.annotation;

/**
 * 注意这里的组合注解必须被spring扫描到，不然会报错
 */
@CombinedAnnotationConfig("com.ya.spring.senior.annotation")
public class AnnotationConfig {

}
