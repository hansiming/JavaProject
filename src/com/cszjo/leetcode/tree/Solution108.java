package com.cszjo.leetcode.tree;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = recursion(nums, start, mid - 1);
        cur.right = recursion(nums, mid + 1, end);

        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TreeNode treeNode = new Solution108().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
