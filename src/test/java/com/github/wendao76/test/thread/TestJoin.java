package com.github.wendao76.test.thread;

import org.junit.Test;

public class TestJoin {
    @Test
    public void testMain() throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadA.join();
        threadB.start();
        Thread.currentThread().join();
    }

    class ThreadA extends Thread{
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println("ThreadA-" + i);
            }
        }
    }

    class ThreadB extends Thread {
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println("ThreadB-" + i);
            }
        }
    }
}
