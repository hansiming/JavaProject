package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
            cur.add(1);
        }
        return cur;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution119().getRow(1);
        System.out.println(row);
    }
}
