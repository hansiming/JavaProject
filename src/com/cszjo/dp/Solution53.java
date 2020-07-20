package com.cszjo.dp;

public class Solution53 {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            } else {
                if (dp[i - 1] + nums[i] > 0) {
                    dp[i] = nums[i] + dp[i - 1];
                } else {
                    dp[i] = nums[i];
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        new Solution53().maxSubArray(nums);
    }
}
