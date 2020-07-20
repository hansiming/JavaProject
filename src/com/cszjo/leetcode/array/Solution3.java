package com.cszjo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
     * @return
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        int res = 1, start = 0, end = 0;
//        Set<Character> set = new HashSet<>();
//        while (start < s.length() && end < s.length()) {
//            if (set.contains(s.charAt(end))) {
//                set.remove(s.charAt(start++));
//            } else {
//                set.add(s.charAt(end++));
//                res = Math.max(set.size(), res);
//            }
//        }
//        return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (m.containsKey(c)) {
                i = Math.max(m.get(c), i);
            }
            m.put(c, j + 1);
            res = Math.max(j - i + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "abba";
        int res = new Solution3().lengthOfLongestSubstring(a);
        System.out.println(res);
    }
}
