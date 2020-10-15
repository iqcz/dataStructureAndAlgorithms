package com.lee.datastructureandalgorithms.tuling;

import com.lee.datastructureandalgorithms.leetcode.DDLNode;

/**
 * 双向链表基本操作
 *
 * @author i324779
 */
public class MyDDLNode {

    int getLength(DDLNode head) {
        int length = 0;
        if (head == null) {
            return 0;
        }
        DDLNode current = head;
        while (current != null) {
            current = current.getNext();
            length++;
        }
        return length;
    }

    /**
     * insert
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    DDLNode insertDDLNode(DDLNode headNode, DDLNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        int length = getLength(headNode);
        if (position > length + 1 || position < 1) {
            System.out.println("Wrong position");
            return headNode;
        }

        if (position == 1) {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            DDLNode previousNode = headNode;
            for (int i = 1; i < position - 1; i++) {
                previousNode = previousNode.getNext();
            }

            DDLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            // 注意这个判断
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    /**
     * delete
     * @param head
     * @param position
     * @return
     */
    DDLNode deleteDDLNode(DDLNode head, int position) {
        if (head == null) {
            return null;
        }

        int length = this.getLength(head);
        if (position > length + 1 || position < 1) {
            System.out.println("Wrong position");
            return head;
        }

        if (position == 1) {
            DDLNode current = head.getNext();
            current.setPrevious(null);
            return current;
        } else {
            DDLNode previous = head;
            for (int i = 1; i < position - 1; i++) {
                previous = previous.getNext();
            }
            DDLNode current = previous.getNext();
            DDLNode later = current.getNext();
            previous.setNext(later);
            // 如果被删除的后继结点不为空，那么设置前驱指针指向被删除结点的前驱结点
            if (later != null) {
                later.setPrevious(previous);
            }
        }
        return head;
    }
}
