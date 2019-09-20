package com.github.wendao76.test.thread;

import org.junit.Test;

public class TestSynchronized {
    @Test
    public void testMain() {

    }

    public synchronized int add(int a, int b) {
        a += 10;
        b*=100;
        return a + b;
    }
}
