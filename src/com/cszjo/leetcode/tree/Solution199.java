package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, 1, 0, res);
        return res;
    }

    private int recursion(TreeNode node, int cur, int target,
                          List<Integer> res) {
        if (node == null) {
            return target;
        }

        if (cur > target) {
            res.add(node.val);
            target++;
        }

        int rightHeight = recursion(node.right, cur + 1, target, res);
        int leftHeight = recursion(node.left, cur + 1, rightHeight, res);

        return Math.max(rightHeight, leftHeight);
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node2;
        node1.left = node3;
        node3.left = node4;

        List<Integer> integers = new Solution199().rightSideView(node1);
        System.out.println(integers);
    }
}
