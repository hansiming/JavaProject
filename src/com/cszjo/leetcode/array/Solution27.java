package com.cszjo.leetcode.array;

public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end--];
                continue;
            }
            start++;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,4};
        int i = new Solution27().removeElement(nums, 1);
        assert i == 3;
    }
}
