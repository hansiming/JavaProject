package com.cszjo.leetcode.link;

public class Solution138 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node r = new Node(cur.val);
            Node next = cur.next;
            cur.next = r;
            r.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
             Node next = cur.next;
             if (cur.random != null) {
                 next.random = cur.random.next;
             }
             cur = next.next;
        }

        Node res = head.next;
        cur = res;
        Node n = res.next;
        while (n != null) {
            cur.next = n.next;
            cur = n.next;
            n = n.next.next;
        }

        return res;
    }

    public Node copyRandomList1(Node head) {
        Node cur = head;
        Node next = null;
        //复制新链表，只复制next指针，不复制random指针
        while(cur!=null){
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        //复制random指针
        while(cur!=null){
            next = cur.next.next;
            cur.next.random = cur.random != null?cur.random.next:null;
            cur = next;
        }
        //把复制链表和源链表分开
        cur = head;
        Node newHead = cur.next;
        Node copyCur = null;
        while(cur!=null){
            //record the next node
            next = cur.next.next;
            copyCur = cur.next;
            cur.next = next;
            copyCur.next = next!=null?next.next:null;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        new Solution138().copyRandomList(node1);
    }
}
