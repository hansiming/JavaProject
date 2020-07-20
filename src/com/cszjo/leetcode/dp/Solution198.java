package com.cszjo.leetcode.dp;

public class Solution198 {

    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        int max = Math.max(nums[0], nums[1]);

        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = nums[1];

        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution198().rob(nums));
    }
}
