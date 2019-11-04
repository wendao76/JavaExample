package com.github.wendao76.proxy;

import com.github.wendao76.proxy.model.CglibProxy;
import com.github.wendao76.proxy.model.CglibRealSubject;

public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        CglibRealSubject realSubject = (CglibRealSubject) proxy.getProxyInstance(CglibRealSubject.class);
        realSubject.doSomething();
    }
}
