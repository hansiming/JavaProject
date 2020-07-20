package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int l = 0, u = 0;
        int d = matrix.length - 1, r = matrix[0].length - 1;

        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            if (r < ++l) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] m = {{3}, {2}};
        int[][] m = {{2,5,8}, {4,0,-1}};
        List<Integer> integers = new Solution54().spiralOrder(m);
        System.out.println(integers);
    }
}
