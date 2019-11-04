package com.github.wendao76.proxy;

import com.github.wendao76.proxy.model.JDKProxy;
import com.github.wendao76.proxy.model.RealSubject;
import com.github.wendao76.proxy.model.Subject;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {

        // 被代理的类
        RealSubject realSubject = new RealSubject();
        // 代理类
        JDKProxy jdkProxy = new JDKProxy(realSubject);
        // 生成代理对象
        Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), new Class[]{Subject.class}, jdkProxy);

        subject.doSomething();
    }
}
