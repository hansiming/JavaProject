package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    private void recursion(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        recursion(node.left, res);
        res.add(node.val);
        recursion(node.right, res);
    }
}
