package com.ya.spring.senior;

import com.ya.spring.senior.annotation.AnnotationConfig;
import com.ya.spring.senior.annotation.AnnotationService;
import com.ya.spring.senior.async.AsyncTaskExecutorService;
import com.ya.spring.senior.aware.AwareService;
import com.ya.spring.senior.condition.ListService;
import com.ya.spring.senior.conf.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class YaSpringSeniorApplication {

    public static void main(String[] args) {
//        SpringApplication.run(YaSpringSeniorApplication.class, args);
        YaSpringSeniorApplication application = new YaSpringSeniorApplication();
//        application.aware();
//        application.asyncTaskExecutor();
        application.scheduled();
//        application.condition();
//        application.annotation();





    }

    /**
     * 组合注解 、元注解的运用
     */
    public void annotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        annotationService.outputResult();
        context.close();
    }




    /**
     * 符合条件才执行
     */
    public void condition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        String cmd = listService.showListCmd();
        System.out.println(context.getEnvironment().getProperty("os.name")+"，查看系统列表的命令："+cmd);
        context.close();
    }



    /**
     * 计划任务
     */
    public  void scheduled(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledConfig.class);
    }



    /**
     * 结果是并发执行并不是顺序执行
     */
    public void asyncTaskExecutor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskExecutorService asyncTaskExecutorService = context.getBean(AsyncTaskExecutorService.class);
        for (int i = 0; i < 6 ; i++) {
            asyncTaskExecutorService.executeAsyncTask(i);
            asyncTaskExecutorService.executeAsyncTaskPlus(i);
        }
        context.close();
    }


    /**
     * bean获取spring其他服务
     */
    public void aware(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();

    }

}
