package com.cszjo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    List<String> res = new ArrayList<>();
    String[] arr = {"(", ")"};

    public List<String> generateParenthesis(int n) {
        recursion(new ArrayList<>(), 0, 0, n * 2);
        return res;
    }

    private void recursion(List<String> cur, int leftCount, int rightCount,
                           int n) {
        if (cur.size() == n) {
            res.add(String.join("", cur));
            return;
        }

        if (leftCount < n / 2) {
            cur.add(arr[0]);
            recursion(cur, leftCount + 1, rightCount, n);
            cur.remove(cur.size() - 1);
        }

        if (leftCount > rightCount) {
            cur.add(arr[1]);
            recursion(cur, leftCount, rightCount + 1, n);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution22().generateParenthesis(3);
        System.out.println(list);
    }
}
