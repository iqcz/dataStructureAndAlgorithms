package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution203 {
    // todo 验证
    public ListNode removeElements(ListNode head, int val) {
        // 使用哨兵，只在head的前面
        ListNode sentinel = new ListNode();
        ListNode previous = sentinel;
        ListNode current = head;
        while (current != null) {
            if (current.getData() == val) {
                previous.setNext(current.getNext());
            } else {
                previous = current;
            }

            current = current.getNext();
        }

        return sentinel.getNext();
    }

    public static void main(String[] args) {

    }
}

/*
 *  public ListNode removeElements(ListNode head, int val) {
 *         ListNode sentinel = new ListNode(0);
 *         sentinel.next = head;
 *         ListNode current = sentinel;
 *         while (current.next != null) {
 *             if (current.next.val == val) {
 *                 current.next = current.next.next;
 *             } else {
 *                 current = current.next;
 *             }
 *         }
 *         return sentinel.next;
 *     }
 */
