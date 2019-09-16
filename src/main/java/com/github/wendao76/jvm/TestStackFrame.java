package com.github.wendao76.jvm;

public class TestStackFrame {
    public static void main(String[] args) {
        TestStackFrame testStackFrame = new TestStackFrame();
        System.out.println(testStackFrame.add(1, 2));
    }

    public int add(int a, int b){
        return a + b;
    }
}
