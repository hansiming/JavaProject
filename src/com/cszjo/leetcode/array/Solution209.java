package com.cszjo.leetcode.array;

public class Solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0, fast = 0;
        int res = Integer.MAX_VALUE, sum = 0;
        for (; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= s) {
                res = Math.min(fast - slow + 1, res);
                sum-=nums[slow++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int res = 6;
        int[] nums = {10,2,3};
        int i = new Solution209().minSubArrayLen(res, nums);
        System.out.println(i);
    }
}
