package com.ya.spring.core.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/26
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private static final String MSG ="world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
