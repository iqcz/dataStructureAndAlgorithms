package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 两数相加 II
 * 如果输入链表不能翻转该如何解决？
 *
 * @author D49450
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.getData());
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.getData());
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curNode = new ListNode(cur);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }
}






