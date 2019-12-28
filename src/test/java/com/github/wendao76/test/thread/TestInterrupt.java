package com.github.wendao76.test.thread;

import org.junit.Test;

/**
 * 线程中断测试
 *  线程运行过程中能够收到中断信息，但是是否中断，需要程序处理
 * @author wendao76
 */
public class TestInterrupt {
    @Test
    public void testInterrupt() throws InterruptedException {
        ThreadInt t = new ThreadInt();
        t.start();
        Thread.sleep(1000);
        t.interrupt();

        Thread.yield();
        System.out.println("main end");
    }
}

class ThreadInt extends Thread {
    Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            if(this.isInterrupted()) {
                System.out.println("我被中断了， 但是仍然可以运行");
//                synchronized (obj) {
//                    obj.notifyAll();
//                    System.out.println("唤醒主线程");
//                }
                return;
            }else{
                System.out.println("正常运行");
            }
        }
    }
}
