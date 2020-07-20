package com.cszjo.leetcode.dp;

public class Solution213 {

    public int rob(int[] nums) {
        int max = 0;
        if (nums == null) {
            return max;
        }

        if (nums.length == 0) {
            return max;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];

        for (int i = 0; i < nums.length - 1; i++) {
            dp1[i + 2] = Math.max(dp1[i] + nums[i], dp1[i + 1]);
            max = Math.max(dp1[i + 2], max);
        }


        for (int i = 1; i < nums.length; i++) {
            dp2[i + 1] = Math.max(dp2[i - 1] + nums[i], dp2[i]);
            max = Math.max(dp2[i + 1], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        int rob = new Solution213().rob(nums);
        System.out.println(rob);
    }
}
