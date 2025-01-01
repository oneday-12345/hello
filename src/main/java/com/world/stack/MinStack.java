package com.world.stack;

import java.util.Stack;

public class MinStack<E extends Comparable<E>> {

    Stack<E> value;
    Stack<E> minValue;

    void push(E e) {
        value.push(e);
        if (minValue.size() == 0) {
            minValue.push(e);
        } else {
            E m = e.compareTo(minValue.peek()) <= 0 ? e : minValue.peek();
            minValue.push(m);
        }
    }

    E pop() {
        if (value.size() > 0) {
            minValue.pop();
            return value.pop();
        }
        return null;
    }

    E peek() {
        if (value.size() > 0) {
            return value.peek();
        }
        return null;
    }

    E min(){
        return minValue.peek();
    }

}