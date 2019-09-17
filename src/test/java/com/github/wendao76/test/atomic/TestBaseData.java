package com.github.wendao76.test.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

public class TestBaseData {
    @Test
    public void testAtomicLong() {
        AtomicLong longValue = new AtomicLong();
        longValue.addAndGet(100);
        System.out.println(longValue);
    }
}
