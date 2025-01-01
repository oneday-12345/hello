package com.world.list;

public class RemoveDuplicate<E> {
    static class ListNode<E> {
        E value;
        ListNode<E> next;
    }

    ListNode<E> deleteDuplicate(ListNode<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<E> prev = head;
        ListNode<E> current = head.next;

        while (current != null) {
            if (current.value == prev.value) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

}
