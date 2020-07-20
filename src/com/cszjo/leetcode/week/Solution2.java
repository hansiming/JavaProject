package com.cszjo.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    public String rankTeams(String[] votes) {

        String vote = votes[0];
        if (votes.length == 1) {
            return vote;
        }

        char[] res = new char[vote.length()];
        int curRes = 0;

        for (int i = 0; i < vote.length(); i++) {
            Map<Character, Integer> cur = new HashMap<>();
            for (int j = 0; j < votes.length; j++) {
                char c = votes[j].charAt(i);
                int cnt = 0;
                if (!cur.containsKey(c)) {
                    cur.put(c, ++cnt);
                } else {
                    Integer integer = cur.get(c);
                    cur.put(c, ++integer);
                }
            }

            int j = votes.length;
            for (; j >= 0; j--) {
                boolean exist = false;
                char resC = 0;
                for (Character c : cur.keySet()) {
                    if (cur.containsKey(c) && cur.get(c) == j) {
                        if (!exist) {
                            resC = c;
                            exist = true;
                        } else {
                            resC = 0;
                            break;
                        }
                    }
                }

                if (exist && resC != 0) {
                    res[curRes++] = resC;
                }
            }
        }

        return new String(res);
    }

    public String rankTeams1(String[] votes) {

        String vote = votes[0];
        if (votes.length == 1) {
            return vote;
        }

        char[] res = new char[vote.length()];
        int curRes = 0;

        Map<Character, Integer> inx = new HashMap<>();
        for (int i = 0; i < vote.length(); i++) {
            inx.put(vote.charAt(i), i);
        }

        for (int i = 0; i < vote.length(); i++) {

            int[] nums = new int[res.length];
            for (int j = 0; j < votes.length; j++) {
                int curInx = inx.get(votes[j].charAt(i));
                nums[curInx]++;
            }

            int max = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != nums[j + 1]) {

                }
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        String[] votes = {"WXYZ","XYZW"};

        String s = new Solution2().rankTeams(votes);

    }
}
