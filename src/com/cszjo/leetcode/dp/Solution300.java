package com.cszjo.leetcode.dp;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tail = new int[nums.length];
        int inx = 1;
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[inx - 1]) {
                tail[inx++] = nums[i];
            } else {
                int start = 0;
                int end = inx - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (tail[mid] < nums[i]) {
                        start = mid + 1;
                    } else if (tail[mid] == nums[i]) {
                        end = mid;
                        break;
                    } else {
                        end = mid;
                    }
                }
                tail[end] = nums[i];
            }
        }

        return inx;
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        new Solution300().lengthOfLIS(nums);
    }
}
