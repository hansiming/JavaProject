package com.cszjo.leetcode.week;


public class Solution3 {

    ListNode first;

    public boolean isSubPath(ListNode head, TreeNode root) {
        first = head;
        return recursion1(head, root);
    }

    private boolean recursion1(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        if (head.val == root.val) {
            if (recursion2(head, root)) {
                return true;
            }
        }

        return recursion1(head, root.left) || recursion1(head, root.right);
    }

    private boolean recursion2(ListNode curListNode, TreeNode curTreeNode) {
        if (curListNode == null) {
            return true;
        }

        if (curTreeNode == null) {
            return false;
        }

        ListNode tmp;
        if (curListNode.val == curTreeNode.val) {
            tmp = curListNode.next;
        } else {
            return false;
        }

        return recursion2(tmp, curTreeNode.left) ||
               recursion2(tmp, curTreeNode.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(3);

        node1.left = node2;
        node2.right = node3;

        node3.left = node4;

        node4.left = node7;

        node4.right = node8;

        ListNode no1 = new ListNode(4);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(8);

        no1.next = no2;
        no2.next = no3;

        System.out.println(new Solution3().isSubPath(no1, node1));
    }
}
