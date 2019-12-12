package com.github.wendao76.v8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wendao76
 */
public class TestMethodReference {
    public static void main(String[] args) {
        Supplier<Person> p = Person::new;
        Person pM = p.get();

        Consumer<String> hello = pM::sayHello;
        hello.accept("wendao76");

        Function<Integer, Integer> myAge = pM::getMyAge;
        System.out.println(myAge.apply(1));
    }
}

class Person {
    public Person() {

    }
    public void sayHello(String msg) {
        System.out.println(msg);
    }

    public Integer getMyAge(int i) {
        return 100 + i;
    }
}
