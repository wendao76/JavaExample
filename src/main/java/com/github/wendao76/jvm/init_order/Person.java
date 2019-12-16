package com.github.wendao76.jvm.init_order;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wendao76
 */
@Data
public class Person {
    private int age = 10;
    private static List<String> children = new ArrayList(){{
        add("child1");
        add("child2");
    }};
    static {
        System.out.println("person.static:child count: "+ children.size());
        System.out.println("person.static.block");
    }
    {
        System.out.println("person.block");
    }
    static {
        System.out.println("person.static.block2");
    }

    public static class PersonInstance {
        private static Person person = new Person();
        static {
            System.out.println("Person.PersonInstance.static");
        }
    }

    public Person() {
        System.out.println("person.construct");
    }

    public static Person getInstance() {
        return PersonInstance.person;
    }
}
