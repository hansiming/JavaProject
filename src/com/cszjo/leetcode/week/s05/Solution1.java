package com.cszjo.leetcode.week.s05;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minInx = 0;
            int curMin = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < curMin) {
                    minInx = j;
                    curMin = matrix[i][j];
                }
            }

            int maxInx = 0;
            int curMax = matrix[0][minInx];
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][minInx] > curMax) {
                    maxInx = j;
                    curMax = matrix[j][minInx];
                }
            }

            if (maxInx == i) {
                res.add(matrix[i][minInx]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{18,17,19}, {9,11,13}, {15,16,17}};
        List<Integer> integers = new Solution1().luckyNumbers(nums);
        System.out.println(integers);
    }
}
