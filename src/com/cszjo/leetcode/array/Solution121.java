package com.cszjo.leetcode.array;

public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            res = res > prices[i] - low ? res : prices[i] - low;
        }
        return res;
    }
}
