package com.lee.datastructureandalgorithms.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author i324779
 */
public class BinaryTreeDemo {

    public static void levelIterator(BinaryTree root) {
        if (root == null) {
            return;
        }

        Deque<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.pop();
            System.out.println("node.data = " + node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(0);
        BinaryTree left = new BinaryTree(1);
        BinaryTree right = new BinaryTree(2);
        root.left = left;
        root.right = right;

        levelIterator(root);

    }
}

class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
    }
}