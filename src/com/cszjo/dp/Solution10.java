package com.cszjo.dp;

public class Solution10 {

    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {

                if (headMatch(s, p, i - 1, j - 1) && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                    continue;
                }

                // ignore current char of p
                if (p.charAt(j - 1) == '*' && dp[i][j - 2]) {
                    dp[i][j] = true;
                    continue;
                }

                // multi char of p
                if (p.charAt(j - 1) == '*' && headMatch(s, p, i, j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private boolean headMatch(String s, String p, int i1, int i2) {
        if (s.charAt(i1) == p.charAt(i2) || p.charAt(i1) == '.') {
            return true;
        }
        return false;
    }
}
