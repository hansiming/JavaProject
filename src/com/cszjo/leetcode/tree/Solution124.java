package com.cszjo.leetcode.tree;

public class Solution124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }

    private int recursion(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        int left = Math.max(0, recursion(cur.left));
        int right = Math.max(0, recursion(cur.right));

        int res = Math.max(cur.val + left + right, cur.val);
        max = Math.max(max, res);
        return res;
    }
}
