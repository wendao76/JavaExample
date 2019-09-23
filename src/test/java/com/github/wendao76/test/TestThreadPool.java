package com.github.wendao76.test;

import org.junit.Test;

import java.util.concurrent.*;

public class TestThreadPool {
    @Test
    public void testConstructor() throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
                new ThreadPoolExecutor.DiscardPolicy());
        CompletionService<Integer> ecs = new ExecutorCompletionService<>(executorService);// 构造器
        ecs.submit(new ThreadA());
        int result = ecs.take().get();
        System.out.println(result);
    }

    @Test
    public void testFactory() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();

        ExecutorService es2 = Executors.newCachedThreadPool();

        ExecutorService es3 = Executors.newFixedThreadPool(20);

        es.submit(new ThreadA());
        CompletionService<Integer> ecs = new ExecutorCompletionService<>(es);// 构造器
        ecs.submit(new ThreadA());
        int result = ecs.take().get();
        System.out.println(result);
    }

    class ThreadA implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return 1000;
        }
    }

    class ThreadB implements Runnable {

        @Override
        public void run() {

        }
    }
}
