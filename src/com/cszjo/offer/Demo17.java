package com.cszjo.offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 非递归实现用Stack
 * Created by hansiming on 2017/10/24.
 */
public class Demo17 {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
