package com.github.wendao76.leetcode.sort;

import java.util.Arrays;

/**
 * @author wendao76
 */
public class Solution1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m,j=0;
        for (;i<m+n; i++,j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 7, 2, 4, 8, 0, 0, 0};
        int[] nums2 = new int[]{1,5,4};
         merge(nums1, 5, nums2,3);
        System.out.println(nums1);
    }
}
