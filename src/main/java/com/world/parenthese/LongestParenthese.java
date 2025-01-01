package com.world.parenthese;

import java.util.Stack;

public class LongestParenthese {

    // 只要涉及到 longest, 存储的就是索引
    private static class Wrapper {
        int index;
        int type; // left = 0, right = 1

        public Wrapper(int index, int type) {
            this.index = index;
            this.type = type;
        }
    }

    int longestParenthese(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        int longest = 0;

        Stack<Wrapper> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {

            char c = s.charAt(i);

            if (c == '(') {
                stack.push(new Wrapper(i, 0));
            } else {

                if (stack.isEmpty() || stack.peek().type == 1) {
                    Wrapper w = new Wrapper(i, 1);
                    stack.push(w);
                } else if (!stack.isEmpty() && stack.peek().type == 0) {

                    Wrapper w = stack.pop();
                    if (stack.isEmpty()) {
                        longest = Math.max(i, longest);
                    } else {
                        longest = Math.max(i - w.index, longest);
                    } // if

                } // if

            } // if

        } // for

        return longest;
    }

}
