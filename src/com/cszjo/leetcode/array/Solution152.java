package com.cszjo.leetcode.array;

public class Solution152 {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int[] max = new int[nums.length];
        max[0] = nums[0];

        int[] min = new int[nums.length];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            }
            res = Math.max(max[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int i = new Solution152().maxProduct(nums);
        System.out.println(i);
    }
}
