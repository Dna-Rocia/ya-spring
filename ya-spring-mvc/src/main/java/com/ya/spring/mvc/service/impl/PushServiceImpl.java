package com.ya.spring.mvc.service.impl;

import com.ya.spring.mvc.service.PushService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/25
 */
@Service
public class PushServiceImpl implements PushService {

    private DeferredResult<String> deferredResult;

    //region

    /**
     * 返回DeferredResult给（客户端）控制器
     * @return
     */
    @Override
    public DeferredResult<String>  getAsyncUpdate(){
       deferredResult = new DeferredResult<String>();
       return deferredResult;
    }
    //endregion


    //region

    /**
     * 定时任务定时刷新deferredResult
     */
    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult(String.valueOf(System.currentTimeMillis()));
        }
    }
    //endregion



}
