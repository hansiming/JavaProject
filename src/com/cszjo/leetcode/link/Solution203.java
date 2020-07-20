package com.cszjo.leetcode.link;

public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode cur = first;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return first.next;
    }
}
