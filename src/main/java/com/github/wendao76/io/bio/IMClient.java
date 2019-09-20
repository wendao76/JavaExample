package com.github.wendao76.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class IMClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        String meg = scanner.nextLine();
                        socket.getOutputStream().write(meg.getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
