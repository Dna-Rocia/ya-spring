package com.ya.spring.basic.conf;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;

@Configuration
@ComponentScan("com.ya.spring.basic.el")
@PropertySource("classpath:com/ya/spring/basic/el/test.properties")
public class ELConfig {
    @Value("I love you") //引入普通字符
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;

    @Value("#{demoSpringELService.another}")
    private String  fromAnother;

    @Value("classpath:com/ya/spring/basic/el/test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${book.name}")
    private String bookName;


    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromAnother);
        System.out.println(IOUtils.toString(testFile.getInputStream(), StandardCharsets.UTF_8));
        System.out.println(IOUtils.toString(testUrl.getInputStream(), StandardCharsets.UTF_8));
        System.out.println(bookName);
        System.out.println(environment.getProperty("book.author"));
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
