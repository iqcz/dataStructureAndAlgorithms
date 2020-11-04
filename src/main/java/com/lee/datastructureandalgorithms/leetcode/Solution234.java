package com.lee.datastructureandalgorithms.leetcode;

import java.util.Stack;

/**
 *
 * @author osyuj
 */
public class Solution234 {
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
}
