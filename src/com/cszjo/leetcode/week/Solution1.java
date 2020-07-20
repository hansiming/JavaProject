package com.cszjo.leetcode.week;

public class Solution1 {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    res[i]++;
                }
            }
        }

        return res;
    }
}
