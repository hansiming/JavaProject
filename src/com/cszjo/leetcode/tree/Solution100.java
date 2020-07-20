package com.cszjo.leetcode.tree;

public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return recursion(p, q);
    }

    private boolean recursion(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        if (!recursion(a.left, b.left)) {
            return false;
        }

        if (!recursion(a.right, b.right)) {
            return false;
        }

        return true;
    }
}
