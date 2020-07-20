package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> cur,
                         int[] nums, int start) {
        res.add(new ArrayList<>(cur));

        for (int i = start; i< nums.length; i++) {
            cur.add(nums[i]);
            subsets(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new Solution78().subsets(nums);
        System.out.println(subsets);
    }
}
