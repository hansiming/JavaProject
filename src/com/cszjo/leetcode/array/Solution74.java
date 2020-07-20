package com.cszjo.leetcode.array;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int i = 0, j = matrix.length - 1;

        while (i < matrix[0].length && j >= 0) {
            if (matrix[j][i] == target) {
                return true;
            } else if (matrix[j][i] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        new Solution74().searchMatrix(nums, 3);
    }
}
