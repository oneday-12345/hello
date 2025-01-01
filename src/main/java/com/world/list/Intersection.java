package com.world.list;

public class Intersection<E> {

    boolean intersection(ListNode<E> head1, ListNode<E> head2) {

        int len1 = length(head1);
        int len2 = length(head2);

        ListNode<E> p1 = head1;
        ListNode<E> p2 = head2;

        while (len1 != len2) {
            if (len1 > len2) {
                p1 = p1.next;
                --len1;
            } else if (len2 > len1) {
                p2 = p2.next;
                --len2;
            }
        }

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            // 只要有写，有变化，就需要立即判断
            // 所以 判断应该放在这里
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    int length(ListNode<E> head) {
        int len = 0;
        ListNode<E> p = head;
        while (p != null) {
            ++len;
            p = p.next;
        }
        return len;
    }

    // A + B = B + A
    boolean intersection2(ListNode<E> head1, ListNode<E> head2) {
        ListNode<E> p1 = head1;
        ListNode<E> p2 = head2;

        while (p1 != p2) {

            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = p2;
            }

            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = p1;
            }

            // 只要有写，有变化，就需要立即判断
            // 所以 判断应该放在这里
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

}
