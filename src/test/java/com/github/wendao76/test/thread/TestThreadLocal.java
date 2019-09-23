package com.github.wendao76.test.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    @Test
    public void testWickReference() {
        Map<MapKey, MapValue> map = new HashMap<>();
        MapKey key1 = new MapKey();
        MapValue val1 = new MapValue();
        map.put(key1, val1);

        MapKey key2 = key1;
        key1 = null;
        System.out.println(map.get(key2));
        System.gc();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
class MapKey{

}

class MapValue{
    int age = 100;
}
class LocalThread{
    public final ThreadLocal<Integer> mask = new ThreadLocal<Integer>();
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
