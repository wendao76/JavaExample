package com.github.wendao76.v8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author wendao76
 */
public class TestStreamAPI {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[2000];
        Stream stream = Arrays.stream(intArr);
        stream.forEach(a-> a = (int)(Math.random() * 2000+1));
        stream.forEach(a-> System.out.println(a));
    }
}
