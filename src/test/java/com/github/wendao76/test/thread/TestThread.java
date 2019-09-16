package com.github.wendao76.test.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    @Test
    public void testSync() {
        //同步测试
        List<ThreadHolder> tList = new ArrayList<ThreadHolder>();
        List<ThreadHolder> tList2 = new ArrayList<ThreadHolder>();
        AddOne addOne = new AddOne();
        for(int i=0; i<1000; i++) {
            tList.add(new ThreadHolder(addOne));
        }
        for(ThreadHolder t: tList) {
            t.start();
        }
        try {
            Thread.sleep(1000);
            System.out.println(addOne.result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AddTwo addTwo = new AddTwo();
        for(int i=0; i<1000; i++) {
            tList2.add(new ThreadHolder(addTwo));
        }
        for(ThreadHolder t: tList2) {
            t.start();
        }
        try {
            Thread.sleep(1000);
            System.out.println(addTwo.result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    interface IAdd{
        void add(int a);
    }
    class AddOne implements IAdd{
        public int result = 0;
        public synchronized void add(int a) {
            result = result + 1;
        }
    }

    class AddTwo implements IAdd{
        public volatile int result = 0;
        public void add(int a) {
            result = result + a;
        }
    }

    class AddThree implements IAdd{
        public volatile AtomicInteger result = new AtomicInteger();
        final ReentrantLock lock = new ReentrantLock();
        public void add(int a) {
            lock.lock();
            try{
                result.getAndAdd(a);
            }finally {
                lock.unlock();
            }
        }
    }

    class ThreadHolder extends Thread{
        private IAdd holder = null;
        public ThreadHolder(IAdd holder) {
            this.holder = holder;
        }
        public void run() {
            holder.add(1);
        }

    }
}
