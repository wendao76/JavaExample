package com.github.wendao76.test.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadOfCyclicBarrier {
    Random random = new Random();

    public void meeting( CyclicBarrier barrier ) {
//        try {
//            Thread.sleep(random.nextInt(4000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(Thread.currentThread().getName() + "  到达，等待会议开始...");

//        if (Thread.currentThread().getName().equals("Thread-1")) {
//            throw new RuntimeException("模拟异常，当出现异常后面的await就不会执行");
//        }

        try {
            //设置barrier，等待被唤醒
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        //barrier.await() 之后线程继续执行
        System.out.println(Thread.currentThread().getName() + "  会议发言...");
    }

    public static void main( String[] args ) {
        ThreadOfCyclicBarrier tcb = new ThreadOfCyclicBarrier();
        //创建一个新的 CyclicBarrier ，当给定数量的线程（线程）正在等待时，它将跳闸，当屏障跳闸时执行给定的屏障动作，由最后一个进入屏障的线程执行。
        CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println(Thread.currentThread().getName() + "不好意思，我是最后一个到的，我们开始开会吧..."));
        for (int i = 0; i < 21; i++) {
            //创建线程，并调用meeting方法将barrier传入方法中
            new Thread(() -> tcb.meeting(barrier)).start();
        }
    }
}
