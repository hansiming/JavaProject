package com.cszjo.leetcode.array;

public class Solution33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[low] <= nums[middle]) {
                if (target >= nums[low] && target <= nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
                continue;
            }

            if (nums[middle] <= nums[high]) {
                if (target <= nums[high] && target > nums[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int search = new Solution33().search(nums, 5);
        System.out.println(search);
    }
}
