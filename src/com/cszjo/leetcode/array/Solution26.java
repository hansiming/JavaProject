package com.cszjo.leetcode.array;

public class Solution26 {

    public int removeDuplicates(int[] nums) {

        int p = 0, q = 1;
        for (; q < nums.length;) {
            if (nums[p] == nums[q]) {

            } else {
                nums[++p] = nums[q];
            }
            q++;
        }

        return nums.length - (q - p - 1);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        new Solution26().removeDuplicates(nums);
    }
}
