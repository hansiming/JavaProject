package com.cszjo.leetcode.tree;

public class Solution {

    int res = 0;

    public int func(TreeNode root, TreeNode node1, TreeNode node2) {

        recursion(root, node1, node2);

        return res;
    }

    public TreeNode recursion(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }

        TreeNode left = recursion(root.left, node1, node2);
        TreeNode right = recursion(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        if (left != null && (left == node1 || left == node2)) {
            res++;
        }

        if (right != null && (right == node1 || right == node2)) {
            res++;
        }

        if (node1 == root) {
            if (left != null || right != null) {
                return root;
            } else {
                return node1;
            }
        }

        if (node2 == root) {
            if (left != null || right != null) {
                return root;
            } else {
                return node2;
            }
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
