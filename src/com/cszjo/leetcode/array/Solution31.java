package com.cszjo.leetcode.array;

public class Solution31 {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        int i = nums.length - 1;
        int k = 0;

        for (; i >= 0; i--) {
            k = i - 1;
            if (i > 0 && nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (k >= 0) {
            for (int j = k + 1; j <= nums.length; j++) {
                if (j != nums.length && nums[j] > nums[k]) {
                    continue;
                }
                int tmp = nums[k];
                nums[k] = nums[j - 1];
                nums[j - 1] = tmp;
                break;
            }
            reverseArray(nums, k + 1, nums.length);
        } else {
            reverseArray(nums, 0, nums.length);
        }
    }

    private void reverseArray(int[] nums, int start, int end) {
        int j = (start + end) / 2 - start;
        for (int i = 0; i < j; i++) {
            int tmp = nums[start + i];
            nums[start + i] = nums[end - i - 1];
            nums[end - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,5};
        new Solution31().nextPermutation(nums);
        System.out.println(nums);
    }
}
