package com.cszjo.leetcode.dp;

public class Solution221 {

    public int maximalSquare(char[][] matrix) {

        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (dp[i][0] == 1) {
                max = 1;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (dp[0][i] == 1) {
                max = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i - 1][j] != 0 && dp[i - 1][j - 1] != 0 &&
                        dp[i][j - 1] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j],
                                            Math.min(dp[i - 1][j - 1],
                                                     dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(dp[i][j] * dp[i][j], max);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matraix = {{'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1',
                '1', '1', '1'}};
        int i = new Solution221().maximalSquare(matraix);
        System.out.println(i);
    }
}
