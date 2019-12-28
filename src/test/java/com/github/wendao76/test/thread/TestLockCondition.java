package com.github.wendao76.test.thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程使用Lock进行通信
 * @author wendao76
 */
public class TestLockCondition {
    private Object obj = new Object();
    @Test
    public void testMain() throws InterruptedException {
        MyService myService = new MyService();
        //线程间通过对象进行锁定
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        Thread.sleep(1000);
        myService.signalA();
        Thread.sleep(1000);
        myService.signalB();
    }

    class MyService {
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void awaitA() {
            System.out.println("线程A开始执行");
            lock.lock();
            try {
                System.out.println("线程A开始等待");
                conditionA.await();
                System.out.println("线程A重新获得锁...");
            } catch (InterruptedException e) {

            }finally {
                lock.unlock();
            }
            System.out.println("线程A执行完成...");
        }

        public void awaitB() {
            System.out.println("线程B开始执行");
            lock.lock();
            try {
                System.out.println("线程B开始等待");
                conditionB.await();
                System.out.println("线程B重新获得锁..");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
            System.out.println("线程B执行完成...");
        }

        public void signalA() {
            try{
                lock.lock();
                conditionA.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void signalB() {
            try{
                lock.lock();
                conditionB.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    class ThreadA extends Thread{
        private MyService myService;
        public ThreadA(MyService myService){
            super();
            this.myService = myService;
        }
        public void run() {
            myService.awaitA();
        }

    }

    class ThreadB extends Thread {
        private MyService myService;
        public ThreadB(MyService myService) {
            super();
            this.myService = myService;
        }

        public void run() {
            myService.awaitB();
        }
    }
}
