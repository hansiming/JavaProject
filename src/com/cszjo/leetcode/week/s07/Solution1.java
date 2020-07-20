package com.cszjo.leetcode.week.s07;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public int[] createTargetArray(int[] nums, int[] index) {

        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int curInx = index[i];
            list.add(curInx, curNum);
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
