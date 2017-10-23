package com.cszjo.offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * Created by hansiming on 2017/10/23.
 */
public class Demo16 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null)
            return false;
        if (root1 == null)
            return false;

        if (root1.val == root2.val) {
            if (dosHasSubtree(root1, root2)) {
                return true;
            }
        }
        if (HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2)){
            return true;
        } else {
            return false;
        }
    }

    private boolean dosHasSubtree (TreeNode root1,TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        if (!dosHasSubtree(root1.left, root2.left) || !dosHasSubtree(root1.right, root2.right)) {
            return false;
        } else {
            return true;
        }
    }
}
