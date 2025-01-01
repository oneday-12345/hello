package com.world.list;

public class OddEven<E> {
    /*
     * ConnectNode
     * 1    2    3    4    5    6    7
     * p1   p2   p1   p2
     * 
     * p1.next=p2.next;
     * p1=p2.next;
     * 
     * p2.next=p1.next;
     * p2=p1.next;
     * 
     * 
     * 
     * ConnectNode
     * 1    2    3    4    5    6    7
     * p1   p2   p1   p2
     * 
     * p1.next=p2.next;
     * p1=p1.next;
     * 
     * p2.next=p1.next;
     * p2=p2.next;
     * 
     */

    ListNode<E> oddEven(ListNode<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<E> newHead = head;
        ListNode<E> p1 = head;
        ListNode<E> p2 = head.next;
        ListNode<E> connectNode = head.next;

        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p1 = p1.next;
            // p1=p2.next;

            p2.next = p1.next;
            p2 = p2.next;
            // p2=p1.next;
        }

        p1.next = connectNode;

        return newHead;
    }

}
