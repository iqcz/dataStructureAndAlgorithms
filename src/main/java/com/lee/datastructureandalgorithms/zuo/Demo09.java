package com.lee.datastructureandalgorithms.zuo;

import java.util.Stack;

/**
 * get min stack
 *
 * @author i324779
 */
public class Demo09 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Demo09() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int newNum) {
        if (this.minStack.isEmpty()) {
            minStack.push(newNum);
        } else if (newNum <= this.getMin()) {
            minStack.push(newNum);
        }
        this.dataStack.push(newNum);
    }

    public int pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.dataStack.pop();
        if (value == getMin()) {
            this.minStack.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.minStack.peek();
    }
}
