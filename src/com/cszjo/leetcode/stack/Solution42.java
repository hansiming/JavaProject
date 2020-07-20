package com.cszjo.leetcode.stack;

import java.util.Stack;

public class Solution42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty()) {
                if (height[s.peek()] > height[i]) {
                    break;
                }
                if (height[s.peek()] <= height[i]) {
                    Integer cur = s.pop();
                    if (s.isEmpty()) {
                        break;
                    }
                    Integer pre = s.peek();
                    if (height[pre] < height[cur]) {
                        continue;
                    }
                    int h = Math.min(height[pre], height[i]) - height[cur];
                    int l = i - pre - 1;
                    res += (h * l);
                }
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Solution42().trap(nums);
    }
}
