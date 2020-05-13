package com.github.wendao76.string;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @Description 类描述信息
 * @ClassName Main
 * @Author wendao76
 * @Date 2020-5-5 21:38
 * @Version 1.0
 */
public class Main {
  public static void main(String[] args) {
	  //
	  String testStr = "00001111222233334444";
    System.out.println(StrUtil.sub(testStr, 0,40) + "...");

    System.out.println(RandomUtil.randomNumbers(6));

    System.out.println(StrUtil.hide("13255055676", 3, 9));
  }
}
