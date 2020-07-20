package com.cszjo.leetcode.array;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (middle == end) {
                return middle;
            }
            if (middle == 0) {
                if (nums[start] > nums[end]) {
                    return start;
                } else {
                    return end;
                }
            }
            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return middle;
            }
            if (nums[middle] > nums[middle + 1]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int peakElement = new Solution162().findPeakElement(nums);
        System.out.println(peakElement);
    }
}
