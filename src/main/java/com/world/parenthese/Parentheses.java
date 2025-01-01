package com.world.parenthese;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Parentheses {
    boolean isValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Set<Character> left = map.keySet();

        Set<Character> right = map
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toSet());

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (left.contains(c)) {
                stack.push(map.get(c));
            } else if (right.contains(c)) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
