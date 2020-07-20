package com.cszjo.leetcode.stack;

import java.util.Stack;

public class Solution84 {

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

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int i = new Solution84().largestRectangleArea(height);
        System.out.println(i);
    }
}
