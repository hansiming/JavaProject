package com.cszjo.leetcode.link;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;

        ListNode slow = first;
        ListNode fast = first;

        int i = 0;
        while (i++ < n) {
            if (i < m) {
                slow = slow.next;
            }
            fast = fast.next;
        }

        ListNode next = fast.next;
        fast.next = null;
        ListNode pre = slow.next;
        reverse(slow.next);
        slow.next = fast;
        pre.next = next;

        return first.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
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
        new Solution92().reverseBetween(node1, 2, 4);
    }
}
