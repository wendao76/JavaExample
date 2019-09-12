package com.github.wendao76.test.model;

import lombok.Data;

@Data
public class Person implements IPrint, IToString{
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

    @Override
    public void printThis() {
        System.out.println(this.toLocalString());
    }

    @Override
    public String toLocalString() {
        return this.toString();
    }
}
