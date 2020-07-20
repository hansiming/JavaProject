package com.cszjo.leetcode.week.s04;

import java.util.Arrays;

public class Solution3 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int max = 0;

        int[] dp = new int[manager.length];
        Arrays.fill(dp, -1);

        dp[headID] = 0;

        while (!isOver(dp)) {
            for (int i = 0; i < manager.length; i++) {
                if (manager[i] == -1) {
                    dp[i] = 0;
                    continue;
                }
                if (dp[i] == -1 && dp[manager[i]] != -1) {
                    dp[i] = dp[manager[i]] + informTime[manager[i]];
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    private boolean isOver(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] man = {1,2,3,4,5,6,-1};
        int[] time = {0,6,5,4,3,2,1};
        int i = new Solution3().numOfMinutes(7, 6, man, time);
        System.out.println(i);
    }
}
