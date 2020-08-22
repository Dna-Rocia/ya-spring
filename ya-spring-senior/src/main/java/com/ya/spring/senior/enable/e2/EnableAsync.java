package com.ya.spring.senior.enable.e2;


import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

import java.lang.annotation.*;

/**
 * 依据条件选择配置类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AsyncConfigurationSelector.class)
public @interface EnableAsync {

    Class<? extends Annotation> annotation() default Annotation.class;
    AdviceMode mode() default AdviceMode.PROXY;//PROXY-则返回ProxyAsyncConfiguration ; ASPECTJ-返回 AspectjAsyncConfiguration
    int order() default Ordered.LOWEST_PRECEDENCE; //过滤器，LOWEST_PRECEDENCE 最低级别过滤


}
