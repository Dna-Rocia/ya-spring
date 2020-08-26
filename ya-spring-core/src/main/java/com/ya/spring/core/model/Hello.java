package com.ya.spring.core.model;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/26
 */
public class Hello {

    private String msg;

    public String sayHello(){
        return "Hello" +msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
