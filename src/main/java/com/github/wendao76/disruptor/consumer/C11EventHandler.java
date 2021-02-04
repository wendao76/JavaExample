package com.github.wendao76.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className C11EventHandler
 * @date 2020-6-22 11:25
 */
public class C11EventHandler implements EventHandler<com.github.wendao76.disruptor.LongEvent>, WorkHandler<com.github.wendao76.disruptor.LongEvent> {
	@Override
	public void onEvent(com.github.wendao76.disruptor.LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		long number = event.getNumber();
		number += 10;
		System.out.println(System.currentTimeMillis() + ": c1-1 consumer finished.number=" + number);
	}

	@Override
	public void onEvent(com.github.wendao76.disruptor.LongEvent event) throws Exception {
		long number = event.getNumber();
		number += 10;
		System.out.println(System.currentTimeMillis() + ": c1-1 consumer finished.number=" + number);
	}
}
