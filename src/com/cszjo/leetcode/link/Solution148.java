package com.cszjo.leetcode.link;

public class Solution148 {

    public ListNode sortList(ListNode head) {

        return recursion(head);
    }

    private ListNode recursion(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode prePart;
        ListNode lastPart;

        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = node;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        prePart = node;
        lastPart = slow;

        prePart = recursion(prePart);
        lastPart = recursion(lastPart);

        ListNode first = new ListNode(-1);
        ListNode tmp = first;
        while (prePart != null && lastPart != null) {
            if (prePart.val < lastPart.val) {
                tmp.next = prePart;
                prePart = prePart.next;
            } else {
                tmp.next = lastPart;
                lastPart = lastPart.next;
            }
            tmp = tmp.next;
        }

        if (prePart != null) {
            tmp.next = prePart;
        } else {
            tmp.next = lastPart;
        }

        return first.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = new Solution148().sortList(node1);
        System.out.println(listNode);
    }
}
