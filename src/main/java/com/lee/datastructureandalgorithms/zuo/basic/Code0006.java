package com.lee.datastructureandalgorithms.zuo.basic;

/**
 * 删除单向链表指定的值，并返回头结点
 *
 * @author i324779
 */
public class Code0006 {

    public static Node removeValue(Node head, int value) {
        while (head != null) {
            if (head.getData() != value) {
                break;
            }
            head = head.getNext();
        }
        // head 来到第一个不需要删除的位置
        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.getData() == value) {
                pre.setNext(cur.getNext()); 
            } else {
                pre = cur;
            }
            cur = cur.getNext();
        }
        return head;
    }
}
