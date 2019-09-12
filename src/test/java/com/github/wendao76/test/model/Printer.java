package com.github.wendao76.test.model;

public class Printer {

    public static <T> void printThis(Class<T> obj) {
        System.out.println(obj.getClass());
    }

    public static void printThis2(Class<?> obj) {
        System.out.println(obj.getClass());
    }

    public static <T extends IPrint&IToString> void printThis3(Class<T> obj) {
        System.out.println(obj.getClass());
    }

    public static <T extends IPrint&IToString> void printThis4(T object) {
        object.printThis();
    }
}
