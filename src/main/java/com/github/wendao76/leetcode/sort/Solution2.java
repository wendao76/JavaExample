package com.github.wendao76.leetcode.sort;

/**
 * 链表排序， 空间复杂度上可能会有问题
 * @author wendao76
 */
public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }
        ListNode lTop, pTop ;
        if(l1.val<l2.val) {
            lTop = pTop = l1;
            l1 = l1.next;
        }else{
            lTop = pTop = l2;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pTop.next = l1;
                l1 = l1.next;
            }else{
                pTop.next = l2;
                l2 = l2.next;
            }
            if(pTop.next != null) {
                pTop = pTop.next;
            }

        }
        if(l1 == null) {
            pTop.next = l2;
        }else{
            pTop.next = l1;
        }
        return lTop;
    }

    public static void main(String[] args) {

    }
}
