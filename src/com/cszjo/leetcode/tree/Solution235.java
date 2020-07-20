package com.cszjo.leetcode.tree;

public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }

        if (root.val <= p.val && root.val >= q.val) {
            return root;
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
