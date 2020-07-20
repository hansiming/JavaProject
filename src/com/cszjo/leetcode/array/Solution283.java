package com.cszjo.leetcode.array;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        for (int slow = 0, fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != 0 && slow < fast) {
                slow++;
                continue;
            }
            if (nums[slow] == 0 && nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 0, 2};
        new Solution283().moveZeroes(nums);
        System.out.println(nums);
    }
}
