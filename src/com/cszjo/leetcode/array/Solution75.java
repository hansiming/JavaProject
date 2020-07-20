package com.cszjo.leetcode.array;

public class Solution75 {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int low = 0, cur = 0, high = nums.length - 1;
        while (cur <= high) {
            if (nums[cur] == 0) {
                if (cur == low) {
                    low++;
                    cur++;
                } else if (nums[low] == 0) {
                    low++;
                } else {
                    int tmp = nums[low];
                    nums[low] = nums[cur];
                    nums[cur] = tmp;
                    cur++;
                }
            } else if (nums[cur] == 2) {
                if (nums[high] == 2) {
                    high--;
                } else {
                    int tmp = nums[high];
                    nums[high] = nums[cur];
                    nums[cur] = tmp;
                }
            } else {
                cur++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        new Solution75().sortColors(nums);
        System.out.println(nums);
    }
}
