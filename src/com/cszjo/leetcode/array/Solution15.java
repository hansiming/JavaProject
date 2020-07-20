package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[i] > 0) {
                    break;
                }
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    res.add(item);
                }
                if (nums[i] + nums[left] + nums[right] <= 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    left += 1;
                } else {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    right -= 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution15().threeSum(nums);
        System.out.println(lists);
    }
}
