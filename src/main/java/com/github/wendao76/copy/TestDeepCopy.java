package com.github.wendao76.copy;

import lombok.Data;

import java.io.*;

/**
 * Java传统序列化
 *  对象属性也必须是可序列化的
 * @author wendao76
 */
public class TestDeepCopy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person(25, "wendao", new Cat("mimi"));
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(p1);
        oos.close();
        System.out.println(bao.toString());
        p1.setAge(100);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bao.toByteArray()));
        Person p2 = (Person) ois.readObject();
        System.out.println(p2.getAge());
    }
}

@Data
class Person implements Serializable {
    private static final long serialVersionUID = -4951400009008622600L;
    private int age;
    private String name;
    private Cat cat;
    public Person(int age, String name, Cat cat) {
        this.age = age;
        this.name = name;
        this.cat = cat;
    }
}

@Data
class Cat implements Serializable {
    private static final long serialVersionUID = 6406358731102751746L;
    private String name;
    public Cat(String name){
        this.name = name;
    }
}