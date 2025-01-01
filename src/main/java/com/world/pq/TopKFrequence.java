package com.world.pq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequence {

    private static class Wrapper {
        public int value;
        public int freq;

        public Wrapper(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    class ValueComparator implements Comparator<Wrapper> {
        public int compare(Wrapper w1, Wrapper w2) {
            return w1.freq - w2.freq;
        }
    }

    List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        if (k > nums.length) {
            for (int i = 0; i < nums.length; ++i) {
                result.add(nums[i]);
            }
            return result;
        }

        Map<Integer, Wrapper> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Wrapper w = map.get(num);
                ++w.freq;
            } else {
                map.put(num, new Wrapper(num, 1));
            }
        }

        PriorityQueue<Wrapper> pq = new PriorityQueue<>(new Comparator<Wrapper>() {
            public int compare(Wrapper w1, Wrapper w2) {
                return w1.freq - w2.freq;
            }
        });

        for (Map.Entry<Integer, Wrapper> entry : map.entrySet()) {
            pq.offer(entry.getValue());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            Wrapper w = pq.poll();
            result.add(w.value);
        }

        return result;
    }

}
