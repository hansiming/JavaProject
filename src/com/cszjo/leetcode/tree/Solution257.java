package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        recursion(root, res, cur);
        return res;
    }

    private void recursion(TreeNode node, List<String> res, List<String> cur) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            cur.add(String.valueOf(node.val));
            res.add(String.join("->", cur));
            cur.remove(cur.size() - 1);
            return;
        }

        cur.add(String.valueOf(node.val));
        recursion(node.left, res, cur);
        recursion(node.right, res, cur);
        cur.remove(cur.size() - 1);
    }
}
