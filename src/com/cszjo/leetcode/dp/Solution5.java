package com.cszjo.leetcode.dp;

public class Solution5 {

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int inx = 0;
        int maxLength = 1;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        } else {
                            continue;
                        }
                    }

                    if (j - i + 1> maxLength) {
                        inx = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }

        return s.substring(inx, inx + maxLength);
    }

    public static void main(String[] args) {
        String abb = new Solution5().longestPalindrome("cbbd");
        System.out.println(abb);
    }
}
