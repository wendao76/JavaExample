package com.github.wendao76.test.thread;

import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipedStream {
    @Test
    public void testPipedStream() throws IOException, InterruptedException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        ThreadA threadA = new ThreadA(in);
        ThreadB threadB = new ThreadB(out);

        in.connect(out);

        threadB.start();
        threadA.start();
        threadA.join();
    }
    class ThreadA extends Thread {
        private PipedInputStream in;
        public ThreadA(PipedInputStream inStream) {
            this.in = inStream;
        }

        public void run() {
            while(true) {
                if(readMessage() == 0) {
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int readMessage() {
            byte[] btArray = new byte[1024];
            try {
                System.out.println("读数据...");
                in.read(btArray);
                String msg = new String(btArray);
                System.out.println(msg);
                if(msg.startsWith("close")) {
                    in.close();
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
    }

    class ThreadB extends Thread {
        private PipedOutputStream out;
        public ThreadB(PipedOutputStream outStream) {
            this.out = outStream;
        }

        public void run() {
            int number = 0;
            while(true) {
                writeMessage("这是第" + (++number) + "条消息");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(number > 20) {
                    try {
                        writeMessage("close");
                        out.close();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void writeMessage(String str) {
            try {
                System.out.println("写数据...");
                out.write(str.getBytes());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
