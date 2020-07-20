package com.cszjo.leetcode.array;

public class Solution81 {

    public boolean search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[middle] > nums[start]) {
                if (nums[middle] > target && nums[start] <= target) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (nums[middle] == nums[start]) {
                start++;
            } else {
                if (nums[middle] < target && nums[end] >= target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,6};
        boolean search = new Solution81().search(nums, 1);
        System.out.println(search);
    }
}
