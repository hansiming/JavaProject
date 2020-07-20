package com.cszjo.leetcode.link;

public class Solution109 {

    public TreeNode sortedListToBST(ListNode head) {
        return generateTreeNode(head);
    }

    private TreeNode generateTreeNode(ListNode node) {
        if (node == null) {
            return null;
        }

        // find middle node
        ListNode pre = null;
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode cur = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
        } else {
            node = null;
        }
        cur.left = generateTreeNode(node);
        cur.right = generateTreeNode(slow.next);
        return cur;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        TreeNode treeNode = new Solution109().sortedListToBST(node1);
        System.out.println(treeNode);
    }
}
