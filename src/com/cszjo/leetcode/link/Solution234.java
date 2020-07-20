package com.cszjo.leetcode.link;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            ListNode next = slow.next;
            fast = fast.next.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {



        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(0);
//        ListNode n6 = new ListNode(0);
//        ListNode n7 = new ListNode(1);

//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n2.next = n4;
//        n4.next = n5;

        n1.next = n5;
        n5.next = n6;
//        n6.next = n7;
        new Solution234().isPalindrome(n1);
    }
}
