package com.cszjo.leetcode.tree;

public class Solution101 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return recursion(root.left, root.right);
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

        if (!recursion(a.left, b.right)) {
            return false;
        }

        if (!recursion(a.right, b.left)) {
            return false;
        }

        return true;
    }
}
