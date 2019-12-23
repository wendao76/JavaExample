package com.github.wendao76.classloader;

import lombok.Data;

@Data
public class Car {
    private String color;
    private Integer wheelCount;
    public void run() {
        System.out.println("更新前的文件");
    }
}
