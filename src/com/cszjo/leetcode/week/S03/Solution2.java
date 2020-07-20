package com.cszjo.leetcode.week.S03;

import java.util.Arrays;
import java.util.HashSet;

public class Solution2 {

//    public int findTheLongestSubstring(String s) {
//
//        if (s == null) {
//            return 0;
//        }
//
//        if (s.length() <= 1) {
//            return s.length();
//        }
//
//        int[][] dp = new int[s.length()][s.length()];
//
//        HashSet<Character> set = new HashSet<>();
//
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//
//        char[] arr = s.toCharArray();
//        if (set.contains(arr[0])) {
//            dp[0][0] = 1;
//        }
//
//        for (int j = 1; j < arr.length; j++) {
//            for (int i = 0; i < arr.length; i++) {
//
//            }
//        }
//    }

//    public int findTheLongestSubstring(String s) {
//        if (s == null) {
//            return 0;
//        }
//
//        char[] arr = s.toCharArray();
//        int start = 0;
//        int end = start + 1;
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (isLongestSubstring(s, i, j)) {
//                    result = Math.max(j - i + 1, result);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private boolean isLongestSubstring(String s, int start, int end) {
//        int countA = 0;
//        int countE = 0;
//        int countI = 0;
//        int countO = 0;
//        int countU = 0;
//
//        for (int i = start; i <= end; i++) {
//            if (s.charAt(i) == 'a') {
//                countA++;
//            }
//            if (s.charAt(i) == 'e') {
//                countE++;
//            }
//            if (s.charAt(i) == 'i') {
//                countI++;
//            }
//            if (s.charAt(i) == 'o') {
//                countO++;
//            }
//            if (s.charAt(i) == 'u') {
//                countU++;
//            }
//        }
//
//        return countA % 2 == 0 && countE % 2 == 0 && countI % 2 == 0 && countO % 2 == 0 && countU % 2 == 0;
//    }

    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int even = 0b0, max = 0;
        int[] dp = new int[1 << 5]; // "各种"情况，首次出现的索引
        Arrays.fill(dp, -1);
        dp[even] = 0; // 现在是完美平衡
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a') even ^= 1;
            else if (c == 'e') even ^= (1 << 1);
            else if (c == 'i') even ^= (1 << 2);
            else if (c == 'o') even ^= (1 << 3);
            else if (c == 'u') even ^= (1 << 4);
            if (dp[even] == -1) dp[even] = i + 1;
            else max = Math.max(max, i + 1 - dp[even]); // 上次出现这种情况的索引
        }
        return max;
    }

    public static void main(String[] args) {
        int eleetminicoworoep = new Solution2().findTheLongestSubstring(
                "eaaaaa");
        System.out.println(eleetminicoworoep);
    }
}
