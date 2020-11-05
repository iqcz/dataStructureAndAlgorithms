package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

public class Solution155 {

    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public Solution155() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            this.stackMin.push(x);
        } else if (x <= getMin()) {
            this.stackMin.push(x);

        }
        this.stackData.push(x);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}

