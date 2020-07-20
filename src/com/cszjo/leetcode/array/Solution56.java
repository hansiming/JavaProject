package com.cszjo.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution56 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Comparator<int[]> comparator = (a1, a2) -> {
            return a1[0] - a2[0];
        };

        Arrays.sort(intervals, comparator);
        LinkedList<int[]> res = new LinkedList<>();

        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            if (intervals[i][0] <= last[1]) {
                if (intervals[i][1] < last[1]) {
                    continue;
                }
                last[1] = intervals[i][1];
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {

//        int[][] nums = {{2,6},{1,3},{8,10},{15,18}};
        int[][] nums = {{1,4}, {2,3}};
        int[][] merge = new Solution56().merge(nums);
        System.out.println(merge);
    }
}
