package com.github.wendao76.string;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className ReplaceTest
 * @date 2020-6-17 9:51
 */
public class ReplaceTest {
	public static void main(String[] args) {
		//
		String str = "测试字符串**一二**三串**一";
		//替换字符或者字符串
		System.out.println(str.replace("串**一", "xxxx"));

		//字符串或者正则替换（如果表达式带通配符会报错）
		System.out.println(str.replaceAll("串**一", "xxxx"));
	}
}
