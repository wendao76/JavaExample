package com.github.wendao76.jvm;

/**
 * 栈帧字节码查看
 * @author wendao76
 */
public class TestStackFrame {
    final int PORT = 3306;
    public static void main(String[] args) {
        TestStackFrame testStackFrame = new TestStackFrame();
        System.out.println(testStackFrame.add(1, 2));
        System.out.println(testStackFrame.add(1.5, 2.7));
    }

    public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b) {
        return a + b + PORT;
    }

    public void init() {

    }
}
