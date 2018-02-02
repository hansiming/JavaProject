package com.cszjo.lintcode.link;

/**
 * Remove Duplicates from Sorted List
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73002
 * Created by hansiming on 2018/2/2.
 */
public class RemoveDuplicateNode {

    // 保持当前节点值不变，直到遇到不同的值，修改节点指针
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
