package com.ya.spring.senior.condition;

public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }
}
