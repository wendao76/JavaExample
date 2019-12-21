package com.github.wendao76.random;

import java.util.concurrent.ThreadLocalRandom;

public class TestThreadLocalRandom {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i=0; i< 100 ;i++) {
            System.out.println(random.nextInt(10000));
        }
    }
}
