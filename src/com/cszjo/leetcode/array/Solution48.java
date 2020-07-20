package com.cszjo.leetcode.array;

public class Solution48 {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        new Solution48().rotate(m);
    }
}
