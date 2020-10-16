package com.lee.datastructureandalgorithms.leetcode;

/**
 * 双向链表结构定义
 * @author i324779
 */
public class DDLNode {
    private int data;

    private DDLNode previous;

    private DDLNode next;

    public DDLNode() {

    }

    public DDLNode(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public DDLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DDLNode previous) {
        this.previous = previous;
    }

    public DDLNode getNext() {
        return next;
    }

    public void setNext(DDLNode next) {
        this.next = next;
    }
}
