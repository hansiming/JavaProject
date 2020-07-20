package com.cszjo.leetcode.dp;

public class Solution72 {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j],
                                                Math.min(dp[i + 1][j],
                                                         dp[i][j + 1])) + 1;
                }
            }
        }

        return dp[arr1.length][arr2.length];
    }

    public static void main(String[] args) {
        int i = new Solution72().minDistance("intention", "execution");
        System.out.println(i);
    }
}
