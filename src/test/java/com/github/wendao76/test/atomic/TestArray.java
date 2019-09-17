package com.github.wendao76.test.atomic;
import	java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

import org.junit.Test;

public class TestArray {
    @Test
    public void testAtomicIntegerArray() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(1, 10);
        System.out.println(array);
    }

    @Test
    public void testAtomicLongArray() {
        AtomicLongArray array = new AtomicLongArray(10);
        array.set(0, 10);
        System.out.println(array);
    }
}
