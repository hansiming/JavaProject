package com.cszjo.leetcode.link;

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        int i = 0;
        while (i++ <= n) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (i == n) {
            return head.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode listNode = new Solution19().removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
}
