package com.cszjo.leetcode.dp;

public class Solution279 {

    public int numSquares(int n) {

        // dp[i] = min(dp[i], dp[i - j * j] + 1)
        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int i = new Solution279().numSquares(5);
        System.out.println(i);
    }
}
