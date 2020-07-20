package com.cszjo.leetcode.array;

public class Solution53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int max = nums[0];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > 0) {
                dp[i + 1] = dp[i] + nums[i];
            } else {
                dp[i + 1] = nums[i];
            }
            max = max > dp[i + 1] ? max : dp[i + 1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int i = new Solution53().maxSubArray(nums);
        System.out.println(i);
    }

}
