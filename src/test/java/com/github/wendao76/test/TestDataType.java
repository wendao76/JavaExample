package com.github.wendao76.test;

import com.github.wendao76.test.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 1. 浮点数精度问题（float, double)
 * @author wendao76
 */
public class TestDataType {
    @Test
    public void testBaseType() {
        int num1 = 10;
        Integer num2 = 10;
        Assert.assertTrue(num1==num2);

        float num3 = 5f;
        float num4 = 5.22f;
        System.out.println("num3=" + num3);
        System.out.println("num4=" + num4);
        System.out.println("num3-num4=" + (num3- num4));
        System.out.println("num3-num4=" + subtract(num3, num4));

        double num5 = 5;
        double num6 = 5.22;
        System.out.println("num6-num5=" + subtract(num6,num5));

        long num7 = 128;
        int num8 = (int)num7;
        System.out.println("num8-num7=" + (num8 - num7));

        int num9 = 128;
        long num10 = num9;
        System.out.println(num10);

        int num11 = 131;
        byte num12 = (byte) num11;
        System.out.println("byte num=" + num12);
    }

    @Test
    public void testDataTranslate() {
        short i = 1;
        int j=1;
        j=i;
        System.out.println(i);
    }

    @Test
    public void testDefaultValue() {
        Person person = new Person();
        System.out.println(person);
    }

    @Test
    public void testBitMove() {
        System.out.println(0<<29);
        System.out.println(1<<29);
    }

    private float subtract(float a, float b) {
        BigDecimal numa = new BigDecimal(Float.toString(a));
        BigDecimal numb = new BigDecimal(Float.toString(b));
        return numa.subtract(numb).floatValue();
    }

    private double subtract(double a, double b) {
        BigDecimal numa = new BigDecimal(Double.toString(a));
        BigDecimal numb = new BigDecimal(Double.toString(b));
        return numa.subtract(numb).doubleValue();
    }
}
