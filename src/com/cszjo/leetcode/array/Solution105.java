package com.cszjo.leetcode.array;


public class Solution105 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return getAns(preorder, inorder, 0, preorder.length - 1, 0,
                      inorder.length - 1);
    }

    public TreeNode getAns(int[] preorder, int[] inorder,
                           int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootValue = preorder[preStart];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++, index++) {
            if (rootValue == inorder[i]) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = getAns(preorder, inorder, preStart + 1,
                           preStart + index, inStart, inStart + index - 1);
        root.right = getAns(preorder, inorder, preStart + index + 1,
                            preEnd, inStart + index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
//        int[] a1 = {3,9,20,15,7};
//        int[] a2 = {9,3,15,20,7};
        int[] a1 = {1,2};
        int[] a2 = {2,1};
        TreeNode treeNode = new Solution105().buildTree(a1, a2);
        System.out.println(treeNode);
    }
}
