package com.github.wendao76.proxy;

import com.github.wendao76.proxy.model.JDKProxy;
import com.github.wendao76.proxy.model.RealSubject;
import com.github.wendao76.proxy.model.Subject;
import com.github.wendao76.proxy.model.Subject2;

import java.lang.reflect.Proxy;

/**
 * jdk代理
 * @author wendao76
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        // 被代理的类
        RealSubject realSubject = new RealSubject();
        // 代理类
        JDKProxy jdkProxy = new JDKProxy(realSubject);
        // 生成代理对象
        Object subject = Proxy.newProxyInstance(RealSubject.class.getClassLoader(), new Class[]{Subject.class, Subject2.class}, jdkProxy);

        Subject sub1 = (Subject) subject;
        Subject2 sub2 = (Subject2) subject;
        sub1.doSomething();
        sub2.doSomething2();
    }
}
