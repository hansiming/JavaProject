package com.cszjo.leetcode.array;

public class Solution11 {

    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0, start = 0, end = height.length - 1;
        while (start < end) {
            int s = (end - start) * Math.min(height[start], height[end]);
            res = s > res ? s : res;
            if (height[start] >= height[end]) {
                end--;
                continue;
            }
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int i = new Solution11().maxArea(nums);
        System.out.println(i);
    }
}
