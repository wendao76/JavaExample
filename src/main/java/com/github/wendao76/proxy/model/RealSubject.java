package com.github.wendao76.proxy.model;

/**
 * 被代理类
 * @author wendao76
 */
public class RealSubject implements Subject,Subject2 {
    @Override
    public void doSomething() {
        System.out.println("this is RealSubject.doSomething");
    }

    @Override
    public void doSomething2() {
        System.out.println("this is RealSubject.doSomething2");
    }
}
