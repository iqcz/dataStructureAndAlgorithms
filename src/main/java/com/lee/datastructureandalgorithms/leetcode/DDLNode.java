package com.lee.datastructureandalgorithms.leetcode;

import lombok.Getter;
import lombok.Setter;

/**
 * 双向链表结构定义
 * @author i324779
 */
@Getter
@Setter
public class DDLNode {
    private int data;

    @Setter
    private DDLNode previous;

    @Setter
    private DDLNode next;

    public DDLNode() {

    }

    public DDLNode(int data) {
        this.data = data;
    }
}
