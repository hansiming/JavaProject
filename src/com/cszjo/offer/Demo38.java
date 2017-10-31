package com.cszjo.offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * Created by hansiming on 2017/10/31.
 */
public class Demo38 {

    private boolean isTrue = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return false;
        IsBalanced_Solution_Core(root);
        return isTrue;
    }

//    private int IsBalanced_Solution_Core(TreeNode root) {
//        if (root == null)
//            return 0;
//        int leftHeight = 0;
//        if (isTrue)
//            leftHeight = IsBalanced_Solution_Core(root.left);
//        int rightHeight = 0;
//        if (isTrue)
//            rightHeight = IsBalanced_Solution_Core(root.right);
//        if (isTrue) {
//            if (Math.abs(leftHeight - rightHeight) > 1 || (root.left != null && root.left.val > root.val) ||
//                    (root.right != null && root.right.val < root.val))
//                isTrue = false;
//        }
//        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
//    }
    private int IsBalanced_Solution_Core(TreeNode root) {
        if(root == null)
            return 0;
        int left = IsBalanced_Solution_Core(root.left);
        int right = IsBalanced_Solution_Core(root.right);

        if(Math.abs(left - right) > 1)
            isTrue = false;
        return right > left ? right + 1 : left + 1;
    }
}
