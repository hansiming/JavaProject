package com.cszjo.leetcode.tree;

public class Solution116 {

    public Node connect(Node root) {
        recursion(root);
        return root;
    }

    private void recursion(Node root) {

        if (root == null) {
            return;
        }

        recursion(root.left);
        recursion(root.right);

        recursion(root.left, root.right);
    }

    private void recursion(Node childLeft, Node childRight) {
        if (childLeft == null) {
            return;
        }

        childLeft.next = childRight;

        if (childLeft.right == null) {
            return;
        }
        recursion(childLeft.right, childRight.left);
    }
}
