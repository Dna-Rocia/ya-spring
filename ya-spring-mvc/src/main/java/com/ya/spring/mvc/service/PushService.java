package com.ya.spring.mvc.service;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/25
 */
public interface PushService {
    //region
    DeferredResult<String> getAsyncUpdate();
}
