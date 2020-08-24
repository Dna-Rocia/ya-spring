package com.ya.spring.mvc.model;

/**
 * @Description
 * @Author ROCIA
 * @Date 2020/8/24
 */
public class Demo {
    private Long id;
    private String name;

    public Demo() {
    }

    public Demo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
