package com.cszjo.leetcode.week.s06;

public class Solution1 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}
