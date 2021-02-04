package com.github.wendao76.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className LongEventFactory
 * @date 2020-6-22 11:23
 */
public class LongEventFactory implements EventFactory<com.github.wendao76.disruptor.LongEvent> {
    @Override
    public com.github.wendao76.disruptor.LongEvent newInstance() {
        return new com.github.wendao76.disruptor.LongEvent();
    }
}
