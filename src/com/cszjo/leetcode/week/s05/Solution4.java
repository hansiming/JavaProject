package com.cszjo.leetcode.week.s05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Solution4 {

    long max = 0;

    public int maxPerformance1(int n, int[] speed, int[] efficiency, int k) {

        int[] curInx = new int[k];
        dfs(speed, efficiency, 0, 0, k, curInx, 0, Integer.MAX_VALUE);
        return (int) (max % Integer.MAX_VALUE);
    }

    private void dfs(int[] speed, int[] efficiency, int deep, int inx, int k,
                     int[] curInx, int curSum, int minEff) {

        max = Math.max(curSum * minEff, max);

        if (deep == k) {
            return;
        }

        for (int i = inx; i < speed.length; i++) {
            curInx[deep] = i;
            int minEff1 = Math.min(minEff, efficiency[i]);
            int curSum1 = curSum + speed[i];
            dfs(speed, efficiency, deep + 1, i + 1, k, curInx, curSum1, minEff1);
        }
    }


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        int[] tmp = new int[speed.length];
        for (int i = 0; i < speed.length; i++) {
            tmp[i] = speed[i] * efficiency[i];
        }

        int res = 0;
        int curSum = 0;
        int curMinInx = Integer.MAX_VALUE;
        int selected = 0;

        int inx = 0;
        while (selected < k) {
            int indx = getIndx(tmp, ++inx);
            curSum += speed[indx];
            int curMinInx1 = Math.min(efficiency[indx], curMinInx);
            if (curSum * curMinInx1 > res) {
                res = curMinInx1 * curSum;
                curMinInx = curMinInx1;
                selected++;
            } else {
                curSum -= speed[indx];
            }
        }

        return res % Integer.MAX_VALUE;
    }

    private int getIndx(int[] arr, int inx) {
        Set<Integer> exists = new HashSet<>();
        int maxInx = -1;
        while (--inx >= 0) {
            maxInx = -1;
            int max = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max && !exists.contains(i)) {
                    max = arr[i];
                    maxInx = i;
                }
            }
            exists.add(maxInx);
        }

        return maxInx;
    }

    public static void main(String[] args) {
        int[] speed = {2,10,3,1,5,8};
        int[] eff = {5,4,3,9,7,2};
        int k = 3;

        int i = new Solution4().maxPerformance(speed.length, speed, eff, k);
        System.out.println(i);
    }
}
