package com.cszjo.leetcode.week.S03;

public class Solution3 {


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    int max = 0;

    public int longestZigZag(TreeNode root) {

        recursion(root, true);

        return max;
    }

    private int recursion(TreeNode cur, boolean isLeft) {
        if (cur == null) {
            return 0;
        }

        int l = recursion(cur.left, true);
        int r = recursion(cur.right, false);

        max = Math.max(Math.max(max, l), r);
        if (isLeft) {
            return r + 1;
        } else {
            return l + 1;
        }
    }

    public static void main(String[] args) {

    }
}
