package com.cszjo.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> curList = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                res.add(new ArrayList<>(curList));
                curList = new ArrayList<>();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                    continue;
                }
            }

            curList.add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(5);

        a.left = a1;
        a.right = a2;

        a2.left = a3;
        a2.right = a4;

        List<List<Integer>> lists = new Solution107().levelOrderBottom(a);
        System.out.println(lists);
    }
}
