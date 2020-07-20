package com.cszjo.leetcode.stack;

import java.util.Stack;

public class Solution155 {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public Solution155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer val = dataStack.pop();
        if (val.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
