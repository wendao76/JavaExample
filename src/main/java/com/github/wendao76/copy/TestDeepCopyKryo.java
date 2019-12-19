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
        Person2 p1 = new Person2(25, "wendao", new Cat2("mimi"));
        Kryo kryo = new Kryo();
        kryo.register(Person2.class);
        kryo.register(Cat2.class);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(new ObjectOutputStream(baos));
        kryo.writeObject(output, p1);
        output.close();

        //读取
        Input input = new Input(new ByteArrayInputStream(baos.toByteArray()));
        Person2 p2 = kryo.readObject(input, Person2.class);
        input.close();

        System.out.println(p2.getCat().getName());
    }
}

@Data
class Person2 {
    private int age;
    private String name;
    private Cat2 cat;
    public Person2() {

    }
    public Person2(int age, String name, Cat2 cat) {
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