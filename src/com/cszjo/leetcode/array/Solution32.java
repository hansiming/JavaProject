package com.cszjo.leetcode.array;

public class Solution32 {

    char[] arr = {'(', ')'};

    public int longestValidParentheses(String s) {

        int[] dp = new int[s.length()];
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == arr[0]) {

            } else {
                if (s.charAt(i - 1) == arr[0]) {
                    if (i - 2 > 0) {
                        dp[i] = dp[i - 2];
                    }
                    dp[i] += 2;
                    max = Math.max(dp[i], max);
                    continue;
                }

                int pre = i - dp[i - 1] - 1;
                if (pre < 0) {
                    continue;
                }
                if (s.charAt(pre) == arr[0]) {
                    if (pre > 0 && dp[pre - 1] > 0) {
                        dp[i] += dp[pre - 1];
                    }
                    dp[i] += dp[i - 1] + 2;
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int i = new Solution32().longestValidParentheses("()(())");
        System.out.println(i);
    }
}
