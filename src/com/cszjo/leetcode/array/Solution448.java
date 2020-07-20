package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - 1) % nums.length;
            nums[idx] += nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers =
                new Solution448().findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
