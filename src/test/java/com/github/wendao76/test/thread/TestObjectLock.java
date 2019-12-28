package com.github.wendao76.test.thread;

import org.junit.Test;

/**
 * 基本线程间通信
 * @author wendao76
 */
public class TestObjectLock {
    private Object obj = new Object();
    @Test
    public void testMain() throws InterruptedException {
        //线程间通过对象进行锁定
        ThreadA threadA = new ThreadA(obj);
        ThreadB threadB = new ThreadB(obj);
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }

    class ThreadA extends Thread{
        private Object objRef;
        public ThreadA(Object objRef){
            this.objRef = objRef;
        }
        public void run() {
            System.out.println("线程A开始执行");
            try {
                System.out.println("线程A开始等待");
                synchronized (objRef) {
                    objRef.wait();
                    System.out.println("线程A重新获得锁...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程A执行完成...");
        }
    }

    class ThreadB extends Thread {
        private Object objRef;

        public ThreadB(Object objRef) {
            this.objRef = objRef;
        }

        public void run() {
            synchronized (objRef) {
                System.out.println("线程B获得了锁..");
                System.out.println("线程B开始执行..");
                objRef.notify();
                System.out.println("线程唤醒正在等待的线程...");
            }
            System.out.println("线程B执行完成...");
        }
    }
}
