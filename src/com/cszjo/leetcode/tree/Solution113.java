package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        recursion(root, res, cur, sum, 0);
        return res;
    }

    private void recursion(TreeNode node, List<List<Integer>> res,
                           List<Integer> cur, int sum, int curSum) {
        if (node == null) {
            return;
        }

        cur.add(node.val);
        curSum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == curSum) {
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return;
            }
        }

        recursion(node.left, res, cur, sum, curSum);
        recursion(node.right, res, cur, sum, curSum);
        cur.remove(cur.size() - 1);
    }
}
