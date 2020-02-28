package com.github.wendao76.test.clazz;

import org.junit.Test;

public class TestMain {
    @Test
    public void testExtend() {
        ClsA clsA = new ClsA();
        ClsB clsB = new ClsB();
//        System.out.println(((ClsB) clsA).fld3);
        System.out.println(((ClsA) clsB));

    }
}

class ClsA {
    public Integer fld1;

    public Integer fld2;
}

class ClsB extends ClsA{
    public Integer fld3;
}
