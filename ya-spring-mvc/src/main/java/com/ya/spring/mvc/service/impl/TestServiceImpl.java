package com.ya.spring.mvc.service.impl;

import com.ya.spring.mvc.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/25
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String saySomething() {
        return "hello";
    }
}
