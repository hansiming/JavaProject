package com.cszjo.leetcode.array;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums == null || nums.length == 0) {
            return res;
        }

        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);

        return res;
    }

    private int searchLeft(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                if (res == -1) {
                    res = middle;
                } else {
                    res = middle < res ? middle : res;
                }
                high = middle - 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return res;
    }

    private int searchRight(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                res = middle > res ? middle : res;
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 5;
        int[] ints = new Solution34().searchRange(arr, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
