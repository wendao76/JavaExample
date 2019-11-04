package com.github.wendao76.proxy.model;

public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("this is RealSubject");
    }
}
