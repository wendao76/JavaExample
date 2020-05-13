package com.github.wendao76.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 类描述信息
 * @ClassName Main
 * @Author wendao76
 * @Date 2020-5-5 21:21
 * @Version 1.0
 */
public class Main {
  public static void main(String[] args) {
    //
    System.out.println(LocalDateTime.parse("2020-05-05T12:08:12", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }
}
