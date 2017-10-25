package com.cszjo.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by hansiming on 2017/10/25.
 */
public class Demo23 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> cur = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null)
            return result;
        target -= root.val;
        cur.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(cur));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        cur.remove(cur.size() - 1);
        return result;
    }
}



















