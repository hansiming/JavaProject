package com.cszjo.leetcode.array;

import java.util.Arrays;

public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        long res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curRes = nums[i] + nums[left] + nums[right];
                if (curRes == target) {
                    return target;
                }

                if (Math.abs(curRes - target) < Math.abs(res - target)) {
                    res = curRes;
                }
                if (curRes < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    left += 1;
                } else  {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    right -= 1;
                }
            }
        }
        return Integer.parseInt(String.valueOf(res));
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        int target = -1;
        int i = new Solution16().threeSumClosest(nums, target);
        System.out.println(i);
    }
}
