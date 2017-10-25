package com.cszjo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * Created by hansiming on 2017/10/25.
 */
public class Demo21 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.poll();
            if (cur == null)
                continue;
            result.add(cur.val);
            stack.offer(cur.left);
            stack.offer(cur.right);
        }
        return result;
    }
}
