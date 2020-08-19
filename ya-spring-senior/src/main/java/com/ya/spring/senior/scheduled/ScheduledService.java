package com.ya.spring.senior.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate : 间隔为多少毫秒
     */
    @Scheduled(fixedRate = 5000)
    public void  reportCurrentTime(){
        System.out.println("每隔5秒执行一次"+simpleDateFormat.format(new Date()));
    }

    /**
     * cron： 定时任务  second  minute  hour  day-of-month  month  day-of-week
     */
    @Scheduled(cron = "0 39 22 ? * *") //每天的22：35 执行
    public void fixTimeExecution(){
        System.out.println("在指定时间："+simpleDateFormat.format(new Date()) +" 执行");
    }


}
