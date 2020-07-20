package com.cszjo.leetcode.array;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int xorRes = 0;
        for (int i = 0; i <= nums.length; i++) {
            xorRes ^= i;
        }
        int missing = xorRes;
        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        int i = new Solution268().missingNumber(nums);
        System.out.println(i);
    }
}
