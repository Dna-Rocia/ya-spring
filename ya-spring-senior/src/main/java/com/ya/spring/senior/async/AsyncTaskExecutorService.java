package com.ya.spring.senior.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 实现多线程并发执行异步任务
 */
@Service
public class AsyncTaskExecutorService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    @Async
    public void  executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:"+i);
    }

}
