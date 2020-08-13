package com.ya.spring.basic.scope;

import org.springframework.stereotype.Service;

/**
 * Service这个注解默认Singleton, 一个spring容器只有一个Bean实例，全容器共享一个实例
 */
@Service
public class DemoSingletonService {
}
