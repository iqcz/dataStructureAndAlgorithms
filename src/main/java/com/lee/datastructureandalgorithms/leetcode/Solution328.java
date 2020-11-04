package com.lee.datastructureandalgorithms.leetcode;

/**
 * 奇偶链表
 *
 * 头尾指针
 * @author osyuj
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // head：奇数的头指针
        //奇数的尾指针
        ListNode odd = head;
        //偶数的尾指针
        ListNode even = head.getNext();
        //偶数的头指针
        ListNode evenHead = even;

        while (even != null && even.getNext() != null) {
            odd.setNext(even.getNext());
            odd = odd.getNext();
            even.setNext(odd.getNext());
            even = even.getNext();
        }
        odd.setNext(evenHead);

        return head;
    }
}
