package com.lee.datastructureandalgorithms.tuling;

import java.util.ArrayDeque;

/**
 * 二叉搜索数
 *
 * @author i324779
 */
public class BinarySearchTree {
    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
    }

    public void insert(BinarySearchTree root, int data) {
        //根节点小，放到右边
        if (root.data < data) {
            if (root.right == null) {
                root.right = new BinarySearchTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new BinarySearchTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    public void find(BinarySearchTree root, int data) {
        if (root != null) {
            if (root.data < data) {
                find(root.right, data);
            } else if (root.data > data) {
                find(root.left, data);
            } else {
                // 找到了
                System.out.println(root.data);
            }
        }
    }

    public void pre() {

    }

    public void post() {

    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void in(BinarySearchTree root) {
        if (root != null) {
            in(root.left);
            System.out.print(root.data + " ");
            in(root.right);
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public void level(BinarySearchTree root) {
        ArrayDeque<BinarySearchTree> queue = new ArrayDeque<>(20);
        queue.add(root);
        while (!queue.isEmpty()) {
            BinarySearchTree tmp = queue.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        //快速排序，归并排序，二叉树排序
        int[] data = {0, 5, 9, 1, 2, 3, 10};
        //第一个点作为根结点
        BinarySearchTree root = new BinarySearchTree(data[0]);
        for (int i = 1; i < data.length; i++) {
            root.insert(root, data[i]);
        }
        System.out.println("中序遍历:");
        root.in(root);
    }
}
