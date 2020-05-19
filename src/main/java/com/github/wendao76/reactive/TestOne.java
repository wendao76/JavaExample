package com.github.wendao76.reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.Scanner;

/**
 * TODO 响应式代码样例（有问题）
 *
 * @Description 类描述信息
 * @ClassName Test1
 * @Author wendao76
 * @Date 2020-4-24 12:46
 * @Version 1.0
 */
public class TestOne {
    public static void main(String[] args) {
        //
        Observable<String> strs = testMap("1", "2");
        strs.doOnNext(str -> {
            System.out.println(str);
        }).doOnComplete(() -> {
        }).toList();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    public static void print(String... names) {

//    Observable.fromArray(names).map(str -> {
//      return str + "s";
//    }).flatMap((strs, (str)->{
//
//    }));
    }

    public static Observable<String> testMap(String... names) {
        return Observable.fromArray(names).map(name -> {
            return name + "a";
        })
                .map(name -> {
                    return "b" + name + "a";
                });
    }
}
