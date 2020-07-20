package com.cszjo.leetcode.array;

public class Solution169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cur = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count = 1;
                continue;
            }

            if (cur == nums[i]) {
                count++;
            } else  {
                count--;
            }
        }
        return cur;
    }


}
