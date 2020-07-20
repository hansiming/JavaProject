package com.cszjo.leetcode.week.s04;

public class Solution2 {

    public int numTimesAllBlue(int[] light) {

        int status = 1 << light.length;
        boolean[] flag = new boolean[light.length];
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            flag[light[i] - 1] = true;
            if (isOk(flag)) {
                res++;
            }
        }

        return res;
    }

    private boolean isOk(boolean[] flag) {

        boolean isTrue = false;
        for (int i = flag.length - 1; i >= 0; i--) {
            if (!isTrue && flag[i]) {
                isTrue = true;
            }

            if (isTrue && !flag[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 18, 8, 30, 10, 11, 12, 13, 14, 17, 16
                , 15, 7, 19, 20, 41, 22, 23, 24, 33, 26, 27, 25, 29, 9, 31,
                32, 28, 34, 35, 36, 37, 38, 39, 40, 21, 42};

        int i = new Solution2().numTimesAllBlue(nums);
        System.out.println(i);
    }
}
