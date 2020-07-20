package com.cszjo.leetcode.array;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p3 >= 0) {
            if (p1 < 0) {
                nums1[p3--] = nums2[p2--];
                continue;
            }
            if (p2 < 0) {
                nums1[p3--] = nums1[p1--];
                continue;
            }
            if (nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0};
        int[] arr1 = {1};

        new Solution88().merge(arr, 0, arr1, 1);
    }
}
