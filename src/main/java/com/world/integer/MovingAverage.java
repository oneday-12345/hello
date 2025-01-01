package com.world.integer;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int size;
    Queue<Integer> queue;
    double sum;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    void next(int value) {
        queue.offer(value);
        sum += value;
        if (queue.size() > this.size) {
            int t = queue.poll();
            sum -= t;
        }
    }

    double avg() {
        return sum / queue.size();
    }
}
