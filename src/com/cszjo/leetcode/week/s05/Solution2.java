package com.cszjo.leetcode.week.s05;

import java.util.Stack;

public class Solution2 {

    static class CustomStack {

        private int maxSize;
        private Stack<Integer> stack = new Stack<>();

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (this.stack.size() < maxSize) {
                stack.push(x);
            }
        }

        public int pop() {
            if (!stack.empty()) {
                return stack.pop();
            } else {
                return -1;
            }
        }

        public void increment(int k, int val) {
            int inx = 0;
            Stack<Integer> tmp = new Stack<>();
            while (!stack.empty()) {
                if (stack.size() <= k) {
                    tmp.push(stack.pop() + val);
                } else {
                    tmp.push(stack.pop());
                }
            }

            while (!tmp.empty()) {
                stack.push(tmp.pop());
            }
        }
    }
}
