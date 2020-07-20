package com.cszjo.leetcode.array;

public class Solution153 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (high == 0) {
                return nums[0];
            }
            if (high == 1) {
                return Math.min(nums[high - 1], nums[high]);
            }
            if (nums[middle] < nums[middle - 1]) {
                return nums[middle];
            }
            if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {2,1};
        int min = new Solution153().findMin(nums);

        System.out.println(min);
    }
}
