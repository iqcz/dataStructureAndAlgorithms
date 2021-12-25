package com.lee.datastructureandalgorithms.offer;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * @author D49450
 */
public class Question25 {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode reversedHead = addReversed(head1, head2);
        return reverseList(reversedHead);
    }

    private ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode(0);
        ListNode sumNode = sentinel;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.getData()) + (head2 == null ? 0 : head2.getData()) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);

            sumNode.setNext(newNode);
            sumNode = sumNode.getNext();

            head1 = head1 == null ? null : head1.getNext();
            head2 = head2 == null ? null : head2.getNext();
            if (carry > 0) {
                sumNode.setNext(new ListNode(carry));
            }
        }
        return sentinel.getNext();
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}