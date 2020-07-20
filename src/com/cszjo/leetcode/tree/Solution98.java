package com.cszjo.leetcode.tree;

public class Solution98 {

    public boolean isValidBST(TreeNode root) {

        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recursion(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return recursion(node.left, min, node.val) &&
               recursion(node.right, node.val, max);
    }
}
