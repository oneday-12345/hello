package com.world.list;

public class SwapPairs<E> {

    ListNode<E> swapPair(ListNode<E> head){
        if(head==null || head.next==null){
            return head;
        }
    
        ListNode<E> p = head;
    
        while(p!=null && p.next!=null && p.next.next!=null){
            // 1,    2,    3,    4,    5
            // t1(p) p.next, t2(p.next.next)
    
            ListNode<E> t1 = p;
            p=p.next;
    
            t1.next=p.next;
    
    
            ListNode<E> t2 = p.next.next;
            p.next.next=p;
            p.next=t2;
            
        }
    
        return head;
    }
}
