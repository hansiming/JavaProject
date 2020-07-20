package com.cszjo.leetcode.array;

public class Solution238 {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];

        lefts[0] = 1;
        rights[rights.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            lefts[i] = lefts[i - 1] * nums[i - 1];
        }

        for (int j = rights.length - 2; j >= 0; j--) {
            rights[j] = rights[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = lefts[i] * rights[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = new Solution238().productExceptSelf(nums);
        System.out.println(ints);
    }
}
