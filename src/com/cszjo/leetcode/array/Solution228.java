package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {

    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int left = 0, right = 1, cur = 0;
        for (; right < nums.length; right++) {
            if (nums[right] - nums[cur] > 1 ||
                (nums[right] == Integer.MAX_VALUE && nums[left] == Integer.MIN_VALUE)) {
                if (left == cur) {
                    res.add(String.valueOf(nums[left]));
                } else {
                    res.add(nums[left] + "->" + nums[cur]);
                }
                left = right;
                cur = right;
                continue;
            }
            cur++;
        }

        if (left == right - 1) {
            res.add(String.valueOf(nums[left]));
        } else {
            res.add(String.valueOf(nums[left] + "->" + nums[right - 1]));
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7, 8};
        int[] nums = {-2147483648,-2147483647,2147483647};
        List<String> list = new Solution228().summaryRanges(nums);
        System.out.println(list);
    }
}
