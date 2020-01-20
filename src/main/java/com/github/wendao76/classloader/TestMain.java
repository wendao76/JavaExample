package com.github.wendao76.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;

/**
 * 类的热加载
 * @author wendao76
 */
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException, IOException {
        loadUser();

        String newFilePath = "E:\\test\\Car.class";
        String newFileCopyPath = "E:\\test\\Car.class.bak";
        String oldFilePath = "E:\\GithubPrjs\\JavaDemo\\target\\classes\\com\\github\\wendao76\\classloader\\Car.class";
        System.gc();
        // 等待资源回收
        Thread.sleep(1000);

        copyFileUsingFileChannels(newFilePath, newFileCopyPath);
        // 需要被热部署的class文件
        File file1 = new File(newFilePath);
        // 之前编译好的class文件
        File file2 = new File(oldFilePath);
        // 删除旧版本的class文件
        boolean isDelete = file2.delete();
        if (!isDelete) {
            System.out.println("热部署失败.");
            return;
        }
        file1.renameTo(file2);

        copyFileUsingFileChannels(newFileCopyPath, newFilePath);
        System.out.println("update success!");
        loadUser();
    }

    /**
     * 文件复制（零拷贝）
     * @param sourceName
     * @param destName
     * @throws IOException
     */
    private static void copyFileUsingFileChannels(String sourceName, String destName) throws IOException {
        File source = null;
        File dest = null;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            source = new File(sourceName);
            dest = new File(destName);

            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    public static void loadUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        MyClassLoader myLoader = new MyClassLoader();
        Class<?> class1 = myLoader.findClass("com.github.wendao76.classloader.Car");
        Object obj1 = class1.newInstance();
        Method method = class1.getMethod("run");
        method.invoke(obj1);
        System.out.println(obj1.getClass());
        System.out.println(obj1.getClass().getClassLoader());
    }
}
