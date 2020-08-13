package com.ya.spring.basic.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 每次调用新建一个实例
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
