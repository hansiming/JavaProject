package com.cszjo.lintcode.string;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Created by hansiming on 2018/1/17.
 */
public class Solution1 {

        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null)
                return -1;
            return haystack.indexOf(needle);
    }
}
