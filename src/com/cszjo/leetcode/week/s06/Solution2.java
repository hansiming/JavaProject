package com.cszjo.leetcode.week.s06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int res = 0;
        if (reservedSeats == null || reservedSeats.length == 0) {
            return res;
        }

        res = n * 2;

//        boolean[][] flags = new boolean[n][10];
//        for (int i = 0; i < reservedSeats.length; i++) {
//            flags[reservedSeats[i][0] - 1][reservedSeats[i][1] - 1] = true;
//        }

        boolean[][] flags = new boolean[n][3];

        for (int i = 0; i <= reservedSeats.length; i++) {
            int index = getIndex(reservedSeats[i][1]);
            if (index == -1) {
                continue;
            }
            if (flags[reservedSeats[i][0] - 1][index]) {
                continue;
            }

            flags[reservedSeats[i][0] - 1][index] = true;
        }

        return res;
    }

    private int getIndex(int i) {
        if (i == 2 || i == 3) {
            return 0;
        } else if (i == 7  || i == 4 || i == 5 || i == 6) {
            return 1;
        } else if (i == 8 || i == 9) {
            return 2;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{4,3},{1,4},{4,6},{1,7}};
        int i = new Solution2().maxNumberOfFamilies(4, nums);
        System.out.println(i);
    }
}
