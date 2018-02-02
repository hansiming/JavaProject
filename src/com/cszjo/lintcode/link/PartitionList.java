package com.cszjo.lintcode.link;

import java.util.List;

/**
 *   Given a linked list and a value x, partition it such that all nodes
     less than x come before nodes greater than or equal to x.

     You should preserve the original relative order of the nodes
     in each of the two partitions.

     For example,
     Given 1->4->3->2->5->2->null and x = 3,
     return 1->2->2->4->3->5->null.
     https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73005
 * Created by hansiming on 2018/2/2.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null || head.next == null)
            return head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftIndex = left;
        ListNode rightIndex = right;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                leftIndex.next = node;
                leftIndex = leftIndex.next;
            } else {
                rightIndex.next = node;
                rightIndex = rightIndex.next;
            }
            node = node.next;
        }
        // right之后可能还有其他节点
        rightIndex.next = null;
        leftIndex.next = right.next;
        return left.next;
    }

    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(1);
        left.next = right;
        new PartitionList().partition(left, 0);
    }
}
