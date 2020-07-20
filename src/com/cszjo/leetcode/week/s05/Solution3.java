package com.cszjo.leetcode.week.s05;

import java.util.LinkedList;

import com.cszjo.leetcode.week.S03.Solution4;

public class Solution3 {


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    private LinkedList<Integer> list = new LinkedList<>();

    public TreeNode balanceBST(TreeNode root) {
        treeNode2LinkedList(root);

        return generateTreeNode(0, list.size() - 1);
    }

    private TreeNode generateTreeNode(int start, int end) {

        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left = generateTreeNode(start, middle - 1);
        node.right = generateTreeNode(middle + 1, end);
        return node;
    }

    private void treeNode2LinkedList(TreeNode root) {
        if (root == null) {
            return;
        }

        treeNode2LinkedList(root.left);
        list.add(root.val);
        treeNode2LinkedList(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        TreeNode treeNode = new Solution3().balanceBST(n1);
        System.out.println(treeNode);
    }
}
