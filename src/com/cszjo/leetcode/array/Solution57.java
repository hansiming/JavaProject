package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {

    public int[][] findContinuousSequence(int target) {
        int mid = (target + 1) / 2;
        int start = 1, end = 2, sum = start + end;
        List<int[]> res = new ArrayList<>();
        for (;end <= mid ; ) {
            if (sum < target) {
                end++;
                sum += end;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                int[] cur = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    cur[i - start] = i;
                }
                res.add(cur);
                sum -= start;
                start++;
            }
        }
        return res.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        new Solution57().findContinuousSequence(9);
    }
}
