package com.github.wendao76.jvm.init_order;

/**
 * @author wendao76
 */
public class Main {
    public static void main(String[] args) {
        Boy boy = new Boy();
        System.out.println(boy.getAge());
    }
}
