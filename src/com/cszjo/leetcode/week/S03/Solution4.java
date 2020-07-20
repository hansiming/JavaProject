package com.cszjo.leetcode.week.S03;

public class Solution4 {

    int max = 0;

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    class Value {
        boolean isBST;
        int val;
        int total;
    }

    public int maxSumBST(TreeNode root) {
        Value value = recursionMax(root.left);
        Value value1 = recursionMin(root.right);
        if (value.isBST && value1.isBST) {
            if (value.val < root.val && value1.val > root.val) {
                return value.total + root.val + value1.total;
            }
        }

        return max;
    }

    private Value recursionMax(TreeNode cur) {
        if (cur == null) {
            Value res = new Value();
            res.isBST = true;
            res.val = Integer.MIN_VALUE;
            return res;
        }
        Value valueMin = recursionMin(cur.right);
        if (!valueMin.isBST) {
            return new Value();
        }
        Value valueMax = recursionMax(cur.left);
        if (!valueMax.isBST) {
            return new Value();
        }

        if (valueMin.val > cur.val && valueMax.val < cur.val) {
            Value res = new Value();
            res.isBST = true;
            res.total = valueMin.total + valueMax.total + cur.val;
            res.val = valueMin.val;
            max = Math.max(res.total, max);
            return res;
        } else {
            return new Value();
        }
    }

    private Value recursionMin(TreeNode cur) {
        if (cur == null) {
            Value res = new Value();
            res.isBST = true;
            res.val = Integer.MAX_VALUE;
            return res;
        }
        Value valueMin = recursionMin(cur.right);
        if (!valueMin.isBST) {
            return new Value();
        }
        Value valueMax = recursionMax(cur.left);
        if (!valueMax.isBST) {
            return new Value();
        }

        if (valueMin.val > cur.val && valueMax.val < cur.val) {
            Value res = new Value();
            res.isBST = true;
            res.total = valueMin.total + valueMax.total + cur.val;
            res.val = valueMax.val;
            max = Math.max(res.total, max);
            return res;
        } else {
            return new Value();
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode5;


        int i = new Solution4().maxSumBST(treeNode1);
        System.out.println(i);

    }
}
