package com.github.wendao76.test.thread;

import org.junit.Test;

public class TestThreadLocal {
    @Test
    public void testThreadLocal() throws InterruptedException {
        LocalThread localThread = new LocalThread();
        ThreadA threadA = new ThreadA(localThread);
        ThreadB threadB = new ThreadB(localThread);

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
    }

}
class LocalThread{
    public static final ThreadLocal<Integer> mask = new ThreadLocal<Integer>();
}

class ThreadA extends Thread{
    private LocalThread referer;
    public ThreadA(LocalThread thread) {
        this.referer = thread;
    }
    public void run() {
        referer.mask.set(100);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadA value=" + referer.mask.get());
        referer.mask.remove();
    }
}

class ThreadB extends Thread{
    private LocalThread referer;
    public ThreadB(LocalThread thread) {
        this.referer = thread;
    }
    public void run() {
        referer.mask.set(200);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadB value=" + referer.mask.get());
        referer.mask.remove();
    }
}
