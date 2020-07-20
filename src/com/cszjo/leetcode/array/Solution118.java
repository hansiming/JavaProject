package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> per = res.get(i - 1);
                    row.add(per.get(j - 1) + per.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution118().generate(5);
        System.out.println(generate);
    }
}
