//package com.cszjo.leetcode.array;
//
//public class Solution215 {
//
//    public int findKthLargest(int[] nums, int k) {
//
//        return recursion(nums, k, 0, nums.length - 1);
//    }
//
//    public int recursion(int[] nums, int k, int low, int high) {
//        int start = low, end = high - 1;
//        int cur = nums[end];
//
//        while (start >= end) {
//            while (nums[start] > cur) {
//                start++;
//            }
//
//            while (nums[end] < cur) {
//                end--;
//            }
//        }
//
//        if (start + 1 == k) {
//            return nums[start];
//        } else if (start + 1 < k) {
//            return recursion(nums, k, low, start - 1);
//        } else {
//            return recursion(nums, k, start + 1, high);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        new Solution215().findKthLargest();
//    }
//
//}
