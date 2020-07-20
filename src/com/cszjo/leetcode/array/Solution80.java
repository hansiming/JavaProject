package com.cszjo.leetcode.array;

public class Solution80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int low = 1, fast = 2;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[low - 1]) {
                nums[++low] = nums[fast];
            }
        }
        return low + 1;
    }
}