package com.github.wendao76.proxy.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {
    // 目标对象
    private Object object;
    public JDKProxy(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------JDKProxy before------------");
        Object invoke = method.invoke(object, args);
        System.out.println("-----------JDKProxy after------------");
        return invoke;
    }
}
