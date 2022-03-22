package com.lee.datastructureandalgorithms.tuling;

import com.lee.datastructureandalgorithms.leetcode.ListNode;

/**
 * 单链表操作
 *
 * @author i324779
 */
public class MyListNode {

    /**
     * 计算单链表的长度
     *
     * @param head 单链表表头
     * @return 链表长度
     */
    int listLength(ListNode head) {
        int length = 0;
        if (head == null) {
            return 0;
        }

        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            length++;
        }
        return length;
    }

    /**
     * 在单链表的指定位置插入新节点
     *
     * @param headNode     单链表头结点
     * @param nodeToInsert 待插入的结点
     * @param position     插入位置
     * @return 插入后的链表头结点
     */
    ListNode insertListNode(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        int length = this.listLength(headNode);
        if (position > length + 1 || position < 1) {
            System.out.println("Wrong position");
            return headNode;
        }

        if (position == 1) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            ListNode previousNode = headNode;
            for (int i = 1; i < position - 1; i++) {
                previousNode = previousNode.getNext();
            }

            nodeToInsert.setNext(previousNode.getNext());
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    ListNode deleteNode(ListNode headNode, int position) {
        if (headNode == null) {
            return null;
        }

        int length = this.listLength(headNode);
        if (position > length + 1 || position < 1) {
            System.out.println("Wrong position");
            return headNode;
        }

        if (position == 1) {
            headNode = headNode.getNext();
            return headNode;
        } else {
            ListNode previousNode = headNode;
            for (int i = 1; i < position - 1; i++) {
                previousNode = previousNode.getNext();
            }
            previousNode.setNext(previousNode.getNext().getNext());
        }
        return headNode;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.getData() + "\t");
            head = head.getNext();
        }
        System.out.println();
    }

    /**
     * 迭代反转
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode next;
        ListNode current;

        current = head;
        while (current != null) {
            //遍历
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            // 指针后移
            current = next;
        }
        return previous;
    }

    /**
     * 递归翻转
     * @param head
     * @return
     */
    private static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = reverseRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        MyListNode myListNode = new MyListNode();

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
        printListNode(head);

        System.out.println("Length:" + myListNode.listLength(head));
        // insert
//        ListNode newNode = new ListNode(9);
//        head = myListNode.insertListNode(head, newNode, 3);
//        printListNode(head);

        // delete
//        head = myListNode.deleteNode(head, 1);
//        printListNode(head);

        ListNode recursionReverseListNode = reverseRecursion(head);
        printListNode(recursionReverseListNode);
    }
}
