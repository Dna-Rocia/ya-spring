package com.ya.spring.senior.enable.e3;


import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableAspectJAutoProxy.class)
public @interface EnableAspectjAutoProxy {

    boolean proxyTargetClass() default false;

}
