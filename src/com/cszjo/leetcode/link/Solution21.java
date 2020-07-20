package com.cszjo.leetcode.link;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }

        if (l2 == null) {
            cur.next = l1;
        }
        return first.next;
    }
}
