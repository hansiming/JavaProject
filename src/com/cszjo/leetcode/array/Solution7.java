package com.cszjo.leetcode.array;

public class Solution7 {

    public int reverse(int x) {

        int res = 0;
        while (x != 0) {
            int temp = x % 10;

            if (x > 214748364) {
                return 0;
            }

            if (x < -214748364) {
                return 0;
            }

            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}
