package com.cszjo.dp;

public class Solution5 {

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int max = 0;
        int maxLength = 1;

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }

                    if (i - j + 1 > maxLength) {
                        max = i;
                        maxLength = i - j + 1;
                    }
                }
            }
        }

        return s.substring(max, max + maxLength);
    }
}
