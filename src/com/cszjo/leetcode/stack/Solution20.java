package com.cszjo.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            if (map.get(stack.pop()) != cur) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
