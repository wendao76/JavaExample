package com.github.wendao76.test;

import org.junit.Test;

public class TestEqual {
    @Test
    public void testEquals() {
        ClassA a = new ClassA();
        ClassB b  = new ClassB();
        System.out.println(a.equals(b));
    }
}

class ClassA {
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();
    }
}

class ClassB {
    public int hashCode() {
        return 100;
    }
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();
    }
}
