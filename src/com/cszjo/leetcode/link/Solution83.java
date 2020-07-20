package com.cszjo.leetcode.link;

public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode low = head;
        ListNode high = head.next;

        while (high != null) {
            if (low.val == high.val) {
                high = high.next;
                low.next = high;
            } else {
                low = low.next;
                high = high.next;
            }
        }

        return head;
    }
}
