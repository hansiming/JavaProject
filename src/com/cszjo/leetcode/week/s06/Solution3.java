package com.cszjo.leetcode.week.s06;

import java.util.TreeSet;

public class Solution3 {

    public int getKth(int lo, int hi, int k) {

        int[] res = new int[hi - lo + 1];
        int cur = lo;
        while (cur <= hi) {
            int inx = cur;
            int curRes = 0;
            while (inx != 1) {
                if (inx % 2 == 0) {
                    inx /= 2;
                } else {
                    inx = inx * 3 + 1;
                }
                curRes++;
            }
            res[cur - lo] = curRes;
            cur++;
        }

        return getKth(res, k) + lo;
    }

    private int getKth(int[] nums, int k) {
        int minInx = 0;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == -1) {
                    continue;
                }
                if (nums[j] < min) {
                    min = nums[j];
                    minInx = j;
                }
            }
            nums[minInx] = -1;
        }
        return minInx;
    }

    public static void main(String[] args) {
        new Solution3().getKth(12, 15, 2);
    }
}
