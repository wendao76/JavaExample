package com.github.wendao76;

public class TestAbc {
    public static void main(String[] args) {
        byte[] placeholder = new byte[128 * 1024*1024];
        placeholder = null;
//        System.gc();
        byte[] placeholder2 = new byte[10*1024*1024];
        System.gc();
        byte[] placeholder3 = new byte[12*1024*1024];
        System.gc();
        byte[] placeholder4 = new byte[14*1024*1024];
        System.gc();
    }
}
