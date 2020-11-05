package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

/**
 * @author osyuj
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
