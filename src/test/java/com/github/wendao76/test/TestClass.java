package com.github.wendao76.test;

import org.junit.Test;

/**
 * 判断一个类是否继承或实现了某个类（instanceof）
 * @author wendao76
 */
public class TestClass {
    @Test
    public void testInstanceOf() {
        ServiceImpl service = new ServiceImpl();
        System.out.println(service instanceof IService);
        System.out.println(service instanceof BaseService);
    }

    @Test
    public void testListInterface(){
        System.out.println(BaseService.class.isAssignableFrom(ServiceImpl.class));
        System.out.println(IService.class.isAssignableFrom(ServiceImpl.class));
    }

    @Test
    public void testClassLoader() {
        //应用类加载器
        System.out.println(ServiceImpl.class.getClassLoader());
        //扩展类加载器
        System.out.println(ServiceImpl.class.getClassLoader().getParent());
        //扩展类加载器没有父类
        System.out.println(ServiceImpl.class.getClassLoader().getParent().getParent());
    }
}

interface IService{
    void sayHello(String name);
}

class BaseService {
    String code;
}
class ServiceImpl extends BaseService implements IService{
    @Override
    public void sayHello(String name) {

    }
}
