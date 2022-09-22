package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

/**
 * @author D49450
 */
public class Solution234 {
    /**
     * 使用栈
     *
     * @param head 链表头结点
     * @return 是否是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }

        while (head != null) {
            if (head.getData() != stack.pop().getData()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    /**
     * 使用快慢指针，找到中点；
     * 后半部分反转进行比较；
     * 考虑，奇数个
     *
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果链表是奇数个结点，把正中的归到左边。
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.getData() != slow.getData()) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}