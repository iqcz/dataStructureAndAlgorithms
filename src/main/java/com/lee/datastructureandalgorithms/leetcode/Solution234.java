package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

/**
 *
 * @author D49450
 */
public class Solution234 {
    /**
     * 使用栈
     * @param head
     * @return
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
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        return false;
    }
}
