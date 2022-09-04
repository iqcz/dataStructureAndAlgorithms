package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class LeeCodeListNode {
    public int val;
    public LeeCodeListNode next;

    public LeeCodeListNode() {
    }

    public LeeCodeListNode(int val) {
        this.val = val;
    }

    public LeeCodeListNode(int val, LeeCodeListNode next) {
        this.val = val;
        this.next = next;
    }
}