package com.cszjo.leetcode.dp;

public class Solution91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int length = s.length();
        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            char c = s.charAt(i - 1);
            if (c != '0') {
                dp[i] = dp[i - 1];
            }
            int cur = (s.charAt(i - 2) - '0') * 10 + c - '0';
            if (cur > 9 && cur <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        new Solution91().numDecodings("12");
    }
}
