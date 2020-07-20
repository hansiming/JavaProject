package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) {
            return res;
        }
        getAns(res, new ArrayList<>(), 0, 1, k, n);
        return res;
    }

    private void getAns(List<List<Integer>> res, List<Integer> item,
                        int sum, int index, int k, int n) {
        if (sum > n) {
            return;
        }
        if (item.size() > k) {
            return;
        }
        if (item.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            item.add(i);
            getAns(res, item, sum + i, i + 1, k, n);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution216().combinationSum3(3, 9);
        System.out.println(lists);
    }
}
