package com.ya.spring.senior.condition;

public class WinListService implements ListService {

    @Override
    public String showListCmd() {
        return "dir";
    }


}
