package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = recursion(start, i - 1);
            List<TreeNode> right = recursion(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();
        List<TreeNode> treeNodes = solution95.generateTrees(3);
        System.out.println(treeNodes);
    }
}
