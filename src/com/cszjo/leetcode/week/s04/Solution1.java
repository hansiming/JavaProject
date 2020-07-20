package com.cszjo.leetcode.week.s04;

import java.util.Arrays;

public class Solution1 {

    public String generateTheString(int n) {

        if (n == 0) {
            return "";
        }

        if (n == 1) {
            return "a";
        }

        char[] arr = new char[n];
        Arrays.fill(arr, 'a');

        if (n % 2 == 0) {
            arr[n - 1] = 'b';
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String s = new Solution1().generateTheString(6);
        System.out.println(s);
    }
}
