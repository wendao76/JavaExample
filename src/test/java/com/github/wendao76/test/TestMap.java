package com.github.wendao76.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class TestMap {
    @Test
    public void testHashTable() {
        Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
        for(int i=0; i<10000; i++) {
            hTable.put(i, "value-" + i);
        }
        System.out.println(hTable);
    }


    @Test
    public void testSet() {
        Set set = new HashSet<String>();
        set.add(null);
        set.add(null);
        set.add("test");
        System.out.println(set.size());
    }
}
