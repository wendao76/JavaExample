package com.github.wendao76.jvm.init_order;

/**
 * @author wendao76
 */
public class Boy extends Person {
    {
        System.out.println("boy.block");
    }

    static {
        System.out.println("boy.static.block");
    }


    public Boy() {
        System.out.println("boy.construct");
    }
}
