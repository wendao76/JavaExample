package com.github.wendao76.leetcode.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * @author wendao76
 */
public class Solution3 {

    public static ListNode sortList(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode result = null;
        ListNode resultPoint = null;

        TreeMap<Integer, List<ListNode>> sortTree = new TreeMap<>();
        ListNode temp, tempLn = null;
        List<ListNode> listNodeListTemp = null;
        while(head != null) {
            temp = head;
            head = head.next;
            temp.next = null;
            System.out.print(temp.val + "  ");
            listNodeListTemp = sortTree.get(temp.val);
            if(listNodeListTemp == null) {
                listNodeListTemp = new LinkedList<>();
            }
            listNodeListTemp.add(temp);
            sortTree.put(temp.val, listNodeListTemp);
        }
        NavigableSet<Integer> keys =  sortTree.navigableKeySet();
        for (Integer key:keys) {
            listNodeListTemp = sortTree.get(key);
            temp = null;
            tempLn = null;
            for (ListNode ln: listNodeListTemp) {
                if(tempLn == null) {
                    tempLn = temp = ln;
                }else{
                    if(temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = ln;
                }
            }
            if(result == null) {
                resultPoint = result = tempLn;
            }else{
                if(resultPoint.next != null) {
                    resultPoint = resultPoint.next;
                }
                resultPoint.next = tempLn;
                resultPoint = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode inputList = null;
        ListNode ln = null;
        ListNode temp;
        int keyVal = 0;
        for (int i= 0; i<15; i++) {
            keyVal = (int)(Math.random() * 200);
            temp = new ListNode(keyVal);
            if(ln == null) {
                inputList = ln = temp;
            }else{
                if(ln.next != null) {
                    ln = ln.next;
                }
                ln.next = temp;
            }
            System.out.print(keyVal + "  ");
        }

        ListNode result = sortList(inputList);
        System.out.println("\nget result");
        while(result!=null) {
            System.out.print( result.val + "  ");
            result = result.next;
        }
    }

    public static void testTreeMap() {
        TreeMap<Integer, String> sortTree = new TreeMap<>();
        sortTree.put(1, "a");
        sortTree.put(5, "aaaaa");
        sortTree.put(5, "aaa");
        sortTree.put(7, "aaaaaaa");
        NavigableSet<Integer> keys =  sortTree.navigableKeySet();
        keys.forEach(item -> {
            System.out.println(item);
        });
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
