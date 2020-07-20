package com.cszjo.leetcode.stack;

import java.util.Stack;

public class Solution85 {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(heights[stack.pop()] * (i - stack.peek() - 1),
                               max);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            Integer cur = stack.pop();
            if (stack.peek() == -1) {
                max = Math.max(heights[cur] * heights.length, max);
            } else {
                max = Math.max(heights[cur] * (heights.length - stack.peek() - 1), max);
            }
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        // dp[]数组存储84题中的柱状图高度(矩阵每列)
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] += 1;
                } else {
                    dp[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(dp));
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0','1','0'}, {'0','1','0'}};
        int i = new Solution85().maximalRectangle(matrix);
        System.out.println(i);
    }
}
