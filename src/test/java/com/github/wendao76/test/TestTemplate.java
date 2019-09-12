package com.github.wendao76.test;

import com.github.wendao76.test.model.Person;
import com.github.wendao76.test.model.Printer;
import org.junit.Test;

public class TestTemplate {
    @Test
    public void testT() {
        Person p = new Person();

        Printer.printThis(p.getClass());

        Printer.printThis2(p.getClass());

        Printer.printThis3(p.getClass());

        Printer.printThis4(p);
    }
}
