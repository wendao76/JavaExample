package com.github.wendao76.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class TestDataContainer {
    @Test
    public void testHashTable() {
        Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
        for(int i=0; i<10000; i++) {
            hTable.put(i, "value-" + i);
        }
        System.out.println(hTable);
    }


    @Test
    public void testConcurrentHashMap() {
        //线程安全
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("testa", 1);
        System.out.println(map);
    }

    @Test
    public void testHashMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("testa", 10000);
        System.out.println(map);
    }

    @Test
    public void testSet() {
        Set set = new HashSet<String>();
        set.add(null);
        set.add(null);
        set.add("test");
        System.out.println(set.size());
    }


    @Test
    public void testVector() {
        //线程安全， synchronized 关键字
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
    }

    @Test
    public void testLinkedHashMap() {
        //accessOrder=true
        LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer, String>(10, 0.75f,true);
        map.put(1, "test");
        map.put(7, "testb");
        map.put(3, "testc");
        System.out.println(map.get(1));
        for (Map.Entry<Integer, String> kv: map.entrySet()) {
            System.out.println(kv.getKey());
        }
        System.out.println(map);

        //accessOrder=false , 和访问顺序无关
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<Integer, String>();
        map2.put(1, "test");
        map2.put(7, "testb");
        map2.put(3, "testc");
        System.out.println(map2.get(1));
        for (Map.Entry<Integer, String> kv: map2.entrySet()) {
            System.out.println(kv.getKey());
        }
        System.out.println(map2);
    }

    @Test
    public void testTreeMap() {
        //红黑树实现， 小的值在左边， 大的值在右边
        //默认前序遍历输出
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(20,"testa");
        map.put(1,"testb");
        map.put(23, "testc");
        System.out.println(map);
    }

    @Test
    public void testCopyOnWriteArrayList() {
        //线程安全， 通过写入时加锁拷贝实现
        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<String>();
        copy.add("testa");
        copy.add("testb");
    }

    @Test
    public void testBlockQueue() {
        LinkedBlockingQueue<String> bq = new LinkedBlockingQueue<String>();
        bq.add("testa");
        bq.offer("testb");
        System.out.println(bq.poll());
        System.out.println(bq);
        bq.offer("testc");
        System.out.println(bq.peek());
        System.out.println(bq);

    }

}
