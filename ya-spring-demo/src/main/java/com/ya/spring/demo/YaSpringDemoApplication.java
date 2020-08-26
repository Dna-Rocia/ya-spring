package com.ya.spring.demo;

import com.ya.spring.core.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
public class YaSpringDemoApplication {

    @Resource
    private Hello hello;

    public static void main(String[] args) {
        SpringApplication.run(YaSpringDemoApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return this.hello.sayHello();
    }

}
