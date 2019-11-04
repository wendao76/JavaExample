package com.github.wendao76.proxy.model;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    public Object getProxyInstance(Class cla) {
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(cla);
        // 3. 设置回调函数
        en.setCallback(this);
        // 4. 创建子类（代理对象）
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------------Before CglibProxy-------------");
        // 目标方法调用
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("-------------After CglibProxy-------------");
        return invoke;
    }
}
