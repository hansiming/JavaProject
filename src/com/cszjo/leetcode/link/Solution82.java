package com.cszjo.leetcode.link;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode(0);

        first.next = head;

        ListNode cur = first;

        while (cur != null && cur.next != null) {
            if (cur.next.next != null && cur.next.val == cur.next.next.val) {
                ListNode tmp = cur.next.next;
                while (tmp != null && tmp.val == cur.next.val) {
                    tmp = tmp.next;
                }
                cur.next = tmp;
            } else {
                cur = cur.next;
            }
        }

        return first.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode listNode = new Solution82().deleteDuplicates(l1);

    }
}
