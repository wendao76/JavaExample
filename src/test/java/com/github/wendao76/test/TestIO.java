package com.github.wendao76.test;

import org.junit.Test;

import java.io.*;

/**
 * IO相关测试
 */
public class TestIO {
    private String testFilePath = "D:\\test.txt";
    @Test
    public void testReader() throws IOException {
        Reader r = new FileReader(testFilePath);
        BufferedReader br = new BufferedReader(r);
        String result = br.readLine();
        br.close();
        r.close();

        System.out.println(result);
    }


    @Test
    public void testWriter() throws IOException {
        //输出为字符，
        Writer writer = new OutputStreamWriter(System.out);
        BufferedWriter bf = new BufferedWriter(writer);
        bf.write("aaaaaaaaaaaa");
        bf.flush();
        bf.close();
        writer.close();


        Writer writer1 = new FileWriter(testFilePath);
        BufferedWriter bw = new BufferedWriter(writer1);
        bw.write("文本测试，看下汉字和abc字幕混排的效果");
        bw.flush();
        bw.close();
        writer1.close();
    }


    @Test
    public void testOutputStream() throws IOException {
        OutputStream os = new PrintStream(System.out);
        String consoleStr = "hello world";
        byte[] bytes = consoleStr.getBytes();
        bytes[0] = 96;

        os.write(bytes);
        os.flush();
        os.close();


        File file = new File(testFilePath);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String str = "abcdefg";
        bos.write(str.getBytes());
        bos.flush();
        bos.close();
        fos.close();
    }

    @Test
    public void testInputStream() throws IOException {
        File file = new File(testFilePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        fis.read(bytes);
        System.out.println(new String(bytes));
        fis.close();
    }
}
