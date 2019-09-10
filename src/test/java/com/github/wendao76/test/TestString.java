package com.github.wendao76.test;

import org.junit.Test;

public class TestString {
    @Test
    public void testStringBuffer() {
        //线程安全
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("testa\n");
        stringBuffer.append("testb\n");
        System.out.println(stringBuffer);
    }

    @Test
    public void testStringBuilder() {
        //非线程安全
        StringBuilder sb = new StringBuilder();
        sb.append("testa");
        sb.append("testb");
        System.out.println(sb);
    }
}
