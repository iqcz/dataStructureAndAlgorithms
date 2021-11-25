package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.google.common.collect.Sets;
import com.lee.datastructureandalgorithms.leetcode.ListNode;

import java.util.Set;

/**
 * @author D49450
 */
public class Sample14 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(null);

        // 设置环形链表
        n4.setNext(n2);
//        MyListNode.printListNode(head);

        System.out.println("haveCycle(head) = " + haveCycle(head));
        System.out.println("haveCycle2(head) = " + haveCycle2(head));
    }

    public static boolean haveCycle(ListNode head) {
        Set<ListNode> set = Sets.newHashSet();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    /**
     * 龟兔赛跑，快慢指针；
     *
     * @param head
     * @return
     */
    public static boolean haveCycle2(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.getNext();
        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}