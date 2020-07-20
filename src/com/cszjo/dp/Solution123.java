package com.cszjo.dp;

public class Solution123 {
    public int maxProfit(int[] prices) {

        int max1 = 0;
        int max2 = 0;
        int minPrice1 = Integer.MAX_VALUE;
        int moneyAfterFirstSell = Integer.MIN_VALUE;

        for (int p : prices) {
            minPrice1 = Math.min(p, minPrice1);

            max1 = Math.max(max1, p - minPrice1);

            moneyAfterFirstSell = Math.max(moneyAfterFirstSell, max1 - p);

            max2 = Math.max(max2, moneyAfterFirstSell + p);
        }

        return max2;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        new Solution123().maxProfit(prices);
    }
}
