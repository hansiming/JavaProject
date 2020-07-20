package com.cszjo.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
