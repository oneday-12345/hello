package com.world.stack;

import java.util.Stack;

public class LargestRectangleArea {
    int largestRectangle(int[] heights) {

        if (heights == null || heights.length <= 0) {
            return 0;
        }

        int max = 0;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (; i < heights.length;) {

            int height = heights[i];

            if (stack.isEmpty() || stack.peek() <= height) {
                stack.push(i);
                ++i;
            } else {
                int t = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[t] * width;
                max = Math.max(area, max);
            }
        }

        while (!stack.isEmpty()) {
            int t = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = heights[t] * width;
            max = Math.max(area, max);
        }

        return max;
    }
}
