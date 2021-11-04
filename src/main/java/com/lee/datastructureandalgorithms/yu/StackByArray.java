package com.lee.datastructureandalgorithms.yu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author D49450
 */
public class StackByArray {
    private final int [] stack;

    private int top;

    public StackByArray(int size) {
        this.stack = new int[size];
        this.top = -1;
    }

    public boolean push(int data) {
        if (top >= stack.length) {
            System.out.println("Stack is full");
            return false;
        }
        stack[++top] = data;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader;
        int value;
        StackByArray stack = new StackByArray(10);
        bufferReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请按照顺输入10个数字");
        for (int i = 0; i < 10; i++) {
            value = Integer.parseInt(bufferReader.readLine());
            stack.push(value);
        }

        System.out.println("===============================");
        while (!stack.isEmpty()) {
            System.out.println("堆栈弹出的顺序为：" + stack.pop());
        }
    }
}
