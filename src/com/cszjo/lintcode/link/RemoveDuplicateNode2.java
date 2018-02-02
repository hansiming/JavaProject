package com.cszjo.lintcode.link;

/**
 *   Given a sorted linked list, delete all nodes that have duplicate numbers,
     leaving only distinct numbers from the original list.

     Example
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73003
 * Created by hansiming on 2018/2/2.
 */
public class RemoveDuplicateNode2 {

    // 保持当前节点值不变，直到遇到不同的值，修改节点指针
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null)
            return head;
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode node = begin;
        while (node.next != null) {
            int val = node.next.val;
            if (node.next.next != null && node.next.next.val == val) {
                while (node.next.next != null && node.next.next.val == val) {
                    node.next = node.next.next;
                }
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return begin.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        new RemoveDuplicateNode2().deleteDuplicates(listNode1);
    }
}
