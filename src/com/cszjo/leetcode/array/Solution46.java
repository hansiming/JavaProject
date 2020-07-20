package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(res, 0, nums, 0, new ArrayList<>());
        return res;
    }

    private void recursion(List<List<Integer>> res, int k, int[] nums,
                           int start, List<Integer> cur) {
        if (k == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, i, start);
            recursion(res, k + 1, nums, start + 1, cur);
            swap(nums, i, start);
            cur.remove(cur.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = new Solution46().permute(nums);
        System.out.println(permute);
    }
}
