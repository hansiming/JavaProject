package com.cszjo.leetcode.tree;

public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return recursion(root, sum, 0);
    }

    private boolean recursion(TreeNode node, int sum, int curSum) {
        curSum += node.val;
        if (node.left == null && node.right == null) {
            return  curSum == sum;
        }

        if (node.left != null) {
            if (recursion(node.left, sum, curSum)) {
                return true;
            }
        }

        if (node.right != null) {
            return recursion(node.right, sum, curSum);
        }

        return false;
    }
}
