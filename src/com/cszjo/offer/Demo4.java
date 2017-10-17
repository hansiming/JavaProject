package com.cszjo.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * Created by hansiming on 2017/10/16.
 */
public class Demo4 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length, in, 0, in.length);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= preEnd)
            return null;
        TreeNode node = new TreeNode(pre[preStart]);
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == pre[preStart]) {
                node.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart + 1, in, inStart, i);
                node.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        new Demo4().reConstructBinaryTree(pre, in);
    }
}
