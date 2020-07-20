package com.cszjo.leetcode.tree;

public class Solution114 {
    public void flatten(TreeNode root) {
        recursion(root);
    }

    private TreeNode recursion(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftLast = recursion(node.left);
        TreeNode rightLast = recursion(node.right);

        if (leftLast == null) {
            return rightLast == null ? node : rightLast;
        }
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = null;
        leftLast.right = tmp;

        return rightLast == null ? leftLast : rightLast;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        new Solution114().flatten(treeNode1);

        System.out.println(treeNode1);
    }
}
