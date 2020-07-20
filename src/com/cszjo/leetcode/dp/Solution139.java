package com.cszjo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        char[] chars = s.toCharArray();

        for (int i = 1; i < s.length() + 1; i++) {
            if (dp[i - 1]) {
                for (String w : wordDict) {
                    if (i - 1 + w.length() > s.length()) {
                        continue;
                    }
                    if (w.equals(new String(chars, i - 1, w.length()))) {
                        dp[i - 1 + w.length()] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dics = new ArrayList<>();
        dics.add("leet");
        dics.add("code");
        new Solution139().wordBreak("leetcode", dics);
    }
}
