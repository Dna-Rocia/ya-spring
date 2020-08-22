package com.ya.spring.senior.test;

import com.ya.spring.senior.conf.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit环境下提供Spring TestContext Framework
@ContextConfiguration(classes = {TestConfig.class}) //用于加载配置 ApplicationContext,  classes用于加载配置类
@ActiveProfiles("prod")
public class TestApplication {

    @Autowired
    private TestBean testBean;

    @Test
    public void contextLoads() {
        String expected = "from production profile";
//        String expected = "from development profile";
        String actual = this.testBean.getContent();
        Assert.assertEquals(expected,actual);


    }


}
