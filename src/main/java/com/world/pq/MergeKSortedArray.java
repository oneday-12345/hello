package com.world.pq;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray<E extends Comparable<E>> {

    public static class ArrayContainer<E extends Comparable<E>> implements Comparable<ArrayContainer<E>> {
        E[] arr;
        int index;

        public ArrayContainer(E[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer<E> other) {
            return this.arr[this.index].compareTo(other.arr[other.index]);
        }
    }

    List<E> mergeKSortedArray(List<E[]> arrays) {
        List<E> result = new ArrayList<>();
        if (arrays == null || arrays.size() == 0) {
            return result;
        }

        PriorityQueue<ArrayContainer<E>> pq = new PriorityQueue<>();
        for (int i = 0; i < arrays.size(); ++i) {
            E[] arr = arrays.get(i);
            pq.offer(new ArrayContainer<>(arr, 0));
        }

        while (!pq.isEmpty()) {
            ArrayContainer<E> container = pq.poll();
            E[] arr = container.arr;
            int index = container.index;
            result.add(arr[index]);
            ++container.index;
            if (container.index < container.arr.length) {
                pq.offer(container);
            }
        }
        return result;
    }

}
