package com.github.wendao76.test.model;

import lombok.Data;

@Data
public class Person {
    private int age;
    private byte sex;
    private double salary;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
