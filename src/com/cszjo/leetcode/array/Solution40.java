package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        combinationSum(candidates, res, new ArrayList<>(), 0,  target);
        return res;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> res,
                                List<Integer> cur, int start, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(deepCopy(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            combinationSum(candidates, res, cur, i + 1, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }

    private List<Integer> deepCopy(List<Integer> input) {
        List<Integer> output = new ArrayList<>(input.size());
        output.addAll(input);
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = new Solution40().combinationSum2(nums, 8);
        System.out.println(lists);
    }
}
