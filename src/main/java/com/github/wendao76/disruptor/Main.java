package com.github.wendao76.disruptor;

import com.github.wendao76.disruptor.consumer.C11EventHandler;
import com.github.wendao76.disruptor.consumer.C12EventHandler;
import com.github.wendao76.disruptor.consumer.C21EventHandler;
import com.github.wendao76.disruptor.consumer.C22EventHandler;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className Main
 * @date 2020-6-22 11:27
 */
public class Main {
    public static void main(String[] args) {
        int bufferSize = 1024 * 1024;//环形队列长度，必须是2的N次方
        EventFactory<com.github.wendao76.disruptor.LongEvent> eventFactory = new LongEventFactory();
        /**
         * 定义Disruptor，基于单生产者，阻塞策略
         */
        Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor = new Disruptor<com.github.wendao76.disruptor.LongEvent>(eventFactory,
                bufferSize,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE, new BlockingWaitStrategy());
        /////////////////////////////////////////////////////////////////////
        parallel(disruptor);//这里是调用各种不同方法的地方.
        /////////////////////////////////////////////////////////////////////
        RingBuffer<com.github.wendao76.disruptor.LongEvent> ringBuffer = disruptor.getRingBuffer();
        /**
         * 输入10
         */
        ringBuffer.publishEvent(new LongEventTranslator(), 10L);
        ringBuffer.publishEvent(new LongEventTranslator(), 100L);
    }

    /**
     * 并行计算实现,c1,c2互相不依赖
     * <br/>
     * p --> c11
     * --> c21
     */
    public static void parallel(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWith(new C11EventHandler(), new C21EventHandler());
        disruptor.start();
    }

    /**
     * 串行依次执行
     * <br/>
     * p --> c11 --> c21
     *
     * @param disruptor
     */
    public static void serial(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWith(new C11EventHandler()).then(new C21EventHandler());
        disruptor.start();
    }

    /**
     * 菱形方式执行
     * <br/>
     * --> c11
     * p          --> c21
     * --> c12
     *
     * @param disruptor
     */
    public static void diamond(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWith(new C11EventHandler(), new C12EventHandler()).then(new C21EventHandler());
        disruptor.start();
    }

    /**
     * 链式并行计算
     * <br/>
     * --> c11 --> c12
     * p
     * --> c21 --> c22
     *
     * @param disruptor
     */
    public static void chain(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWith(new C11EventHandler()).then(new C12EventHandler());
        disruptor.handleEventsWith(new C21EventHandler()).then(new C22EventHandler());
        disruptor.start();
    }

    /**
     * 并行计算实现,c1,c2互相不依赖,同时C1，C2分别有2个实例
     * <br/>
     * p --> c11
     * --> c21
     */
    public static void parallelWithPool(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWithWorkerPool(new C11EventHandler(), new C11EventHandler());
        disruptor.handleEventsWithWorkerPool(new C21EventHandler(), new C21EventHandler());
        disruptor.start();
    }

    /**
     * 串行依次执行,同时C11，C21分别有2个实例
     * <br/>
     * p --> c11 --> c21
     *
     * @param disruptor
     */
    public static void serialWithPool(Disruptor<com.github.wendao76.disruptor.LongEvent> disruptor) {
        disruptor.handleEventsWithWorkerPool(new C11EventHandler(), new C11EventHandler()).then(new C21EventHandler(), new C21EventHandler());
        disruptor.start();
    }
}
