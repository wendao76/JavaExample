package com.github.wendao76.v8;

import java.util.Optional;

public class TestOptional {
    public static void main(String[] args) {
        Optional<String> str = Optional.ofNullable(null);
        System.out.println(str.isPresent());
        System.out.println(str.orElseGet(()->"none"));
    }
}
