package com.lee.datastructureandalgorithms.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 通过次数363,114提交次数983,252
 * 善用哨兵结点
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = sentinel;

        // 进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 != null ? p1.getData() : 0;
            int y = p2 != null ? p2.getData() : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.setNext(new ListNode(sum % 10));
            curr = curr.getNext();
            if (p1 != null) {
                p1 = p1.getNext();
            }
            if (p2 != null) {
                p2 = p2.getNext();
            }
        }
        if (carry >= 0) {
            curr.setNext(new ListNode(carry));
        }
        return sentinel.getNext();
    }
}
