package com.world.list;

public class Reverse<E> {


    ListNode<E> reverseIterator(ListNode<E> head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode<E> prev = null;
        ListNode<E> current = head;
        ListNode<E> next = null;

        while (current != null) {
            // prev, current, next
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    ListNode<E> reverse(ListNode<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<E> first = head;
        ListNode<E> second = first.next;

        ListNode<E> newHead = reverse(second);

        second.next = first;
        first.next = null;

        return newHead;
    }

}
