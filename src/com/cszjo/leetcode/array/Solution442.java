package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] < 0) {
                res.add(cur);
            } else {
                nums[cur - 1] = -nums[cur - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,3};
        List<Integer> duplicates = new Solution442().findDuplicates(nums);
        System.out.println(duplicates);
    }
}
