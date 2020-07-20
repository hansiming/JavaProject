package com.cszjo.leetcode.array;

public class Solution55 {

    public boolean canJump(int[] nums) {

        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m < i) {
                return false;
            }
            m = Math.max(m, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,1};
        boolean b = new Solution55().canJump(nums);
        System.out.println(b);
    }
}
