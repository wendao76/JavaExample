package com.github.wendao76.disruptor.consumer;


import com.github.wendao76.disruptor.LongEvent;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className C12EventHandler
 * @date 2020-6-22 11:26
 */
public class C12EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {
	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		long number = event.getNumber();
		number *= 10;
		System.out.println(System.currentTimeMillis() + ": c1-2 consumer finished.number=" + number);
	}

	@Override
	public void onEvent(LongEvent event) throws Exception {
		long number = event.getNumber();
		number *= 10;
		System.out.println(System.currentTimeMillis() + ": c1-2 consumer finished.number=" + number);
	}
}
