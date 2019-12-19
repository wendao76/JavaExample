package com.github.wendao76.copy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.Data;

import java.io.*;

/**
 * Kryo有问题， 需要进一步处理
 *  https://github.com/EsotericSoftware/kryo/blob/master/README.md
 *  对象属性也必须是可序列化的
 * @author wendao76
 */
public class TestDeepCopyKryo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Kryo kryo = new Kryo();
        Human h1 = new Human(25, "wendao", new Cat2("mimi"));
        kryo.register(Human.class);
        kryo.register(Cat2.class);

        //深拷贝
        Human hCopy1 = kryo.copy(h1);
        //浅拷贝
        Human hCopy2 = kryo.copyShallow(h1);

        System.out.println(hCopy1.getCat().getName());
        System.out.println(hCopy2.getCat().getName());
        h1.getCat().setName("miaomiao");
        System.out.println("h1 changed！");
        System.out.println(hCopy1.getCat().getName());
        System.out.println(hCopy2.getCat().getName());
    }
}

@Data
class Human {
    private int age;
    private String name;
    private Cat2 cat;
    public Human() {

    }
    public Human(int age, String name, Cat2 cat) {
        this.age = age;
        this.name = name;
        this.cat = cat;
    }
}

@Data
class Cat2 {
    private String name;
    public Cat2() {

    }
    public Cat2(String name){
        this.name = name;
    }
}
