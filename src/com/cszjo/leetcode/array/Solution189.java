package com.cszjo.leetcode.array;

public class Solution189 {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2};
        new Solution189().rotate(ints, 1);
        System.out.println(ints);
    }
}
