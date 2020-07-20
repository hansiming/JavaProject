package com.cszjo.leetcode.dp;

public class Solution264 {

    public int nthUglyNumber(int n) {

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int inx2 = 0;
        int inx3 = 0;
        int inx5 = 0;
        int inx = 0;

        for (int i = 1; i < n; i++) {

            dp[++inx] = Math.min(dp[inx2] * 2, Math.min(dp[inx3] * 3,
                                                        dp[inx5] * 5));

            while (dp[inx2] * 2 <= dp[inx]) {
                inx2++;
            }

            while (dp[inx3] * 3 <= dp[inx]) {
                inx3++;
            }

            while (dp[inx5] * 5 <= dp[inx]) {
                inx5++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int i = new Solution264().nthUglyNumber(5);
    }
}
