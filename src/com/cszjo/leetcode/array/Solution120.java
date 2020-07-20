package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                    continue;
                }

                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            Integer v = dp[i];
            if (res > v) {
                res = v;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] a1 = {2};
        Integer[] a2 = {3,4};
        Integer[] a3 = {6,5,7};
        Integer[] a4 = {4,1,8,3};

        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(a1));
        input.add(Arrays.asList(a2));
        input.add(Arrays.asList(a3));
        input.add(Arrays.asList(a4));

        int i = new Solution120().minimumTotal(input);
        System.out.println(i);
    }
}
