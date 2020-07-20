package com.cszjo.leetcode.array;

public class Solution73 {

    public void setZeroes(int[][] matrix) {

        boolean col = false;
        boolean row = false;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (col) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1}, {1,0,1}, {1,1,1}};
        new Solution73().setZeroes(nums);
        System.out.println(nums);
    }
}
