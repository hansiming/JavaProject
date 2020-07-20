package com.cszjo.leetcode.link;

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val < cur.val) {
                ListNode first = pre;
                while (first.next.val < next.val) {
                    first = first.next;
                }
                cur.next = next.next;
                next.next = first.next;
                first.next = next;
            } else  {
                cur = next;
            }
        }

        return pre.next;
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

        ListNode listNode = new Solution147().insertionSortList(node1);
        System.out.println(listNode);
    }
}
