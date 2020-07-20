package com.cszjo.leetcode.tree;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        recursion(root);
        return root;
    }

    private void recursion(TreeNode node) {
        if (node == null) {
            return;
        }

        recursion(node.left);
        recursion(node.right);

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
