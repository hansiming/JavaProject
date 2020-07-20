package com.cszjo.leetcode.tree;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        return recursion(root, 0);
    }

    public int recursion(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(recursion(node.left, depth + 1), recursion(node.right
                , depth + 1));
    }
}
