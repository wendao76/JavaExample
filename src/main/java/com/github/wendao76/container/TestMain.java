package com.github.wendao76.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList(){{
            add(1);
            add(6);
            add(12);
        }};

        List<Integer> list2 = new ArrayList(){{
            add(6);
            add(7);
            add(13);
        }};

        List<Integer> result = list1.stream().filter( item -> {
            return !list2.contains(item);
        }).collect(Collectors.toList());

        for (Integer a: result) {
            System.out.println(a);
        }
    }
}
