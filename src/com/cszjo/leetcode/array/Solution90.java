package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getAns(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void getAns(int[] nums, List<List<Integer>> res,
                        List<Integer> cur, int index) {
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            getAns(nums, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = new Solution90().subsetsWithDup(nums);
        System.out.println(lists);
    }
}
