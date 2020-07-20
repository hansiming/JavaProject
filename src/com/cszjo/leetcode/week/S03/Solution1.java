package com.cszjo.leetcode.week.S03;

import java.util.Arrays;

public class Solution1 {

    public String sortString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        char[] res = new char[arr.length];
        boolean[] flags = new boolean[arr.length];
        Arrays.sort(arr);
        int inx = 0;

        while (inx <= arr.length - 1) {
            char cur = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!flags[i] && cur != arr[i]) {
                    flags[i] = true;
                    res[inx++] = arr[i];
                    cur = arr[i];
                }
            }

            cur = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (!flags[i] && cur != arr[i]) {
                    flags[i] = true;
                    res[inx++] = arr[i];
                    cur = arr[i];
                }
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        new Solution1().sortString("leetcode");
    }
}
