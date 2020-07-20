package com.cszjo.leetcode.tree;

public class Solution222 {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == rightHeight) {
            // left is full tree
            return ((1 << leftHeight) - 1) + countNodes(root.right) + 1;
        } else {
            // right is full tree
            return ((1 << rightHeight) - 1) + countNodes(root.left) + 1;
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
