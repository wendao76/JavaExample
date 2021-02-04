package com.github.wendao76.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className LongEventTranslator
 * @date 2020-6-22 11:24
 */
public class LongEventTranslator implements EventTranslatorOneArg<com.github.wendao76.disruptor.LongEvent, Long> {
	@Override
	public void translateTo(com.github.wendao76.disruptor.LongEvent event, long sequence, Long arg0) {
		event.setNumber(arg0);
	}
}
