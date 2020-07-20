package com.cszjo.dp;

public class Solution32 {

    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                continue;
            }

            if (s.charAt(i - 1) == '(') {
                if (i - 1 > 0) {
                    dp[i] = dp[i - 2];
                }
                dp[i] += + 2;
                max = Math.max(max, dp[i]);
                continue;
            }

            int j = i - dp[i - 1] - 1;
            if (j < 0) {
                continue;
            }
            if (s.charAt(j) == '(') {
                if (j - 1 > 0) {
                    dp[i] = dp[j - 1];
                }
                dp[i] += dp[i - 1] + 2;
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        String input = "()(())";

        new Solution32().longestValidParentheses(input);
    }
}
