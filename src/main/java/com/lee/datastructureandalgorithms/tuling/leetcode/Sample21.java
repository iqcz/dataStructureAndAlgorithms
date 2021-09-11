package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.lee.datastructureandalgorithms.leetcode.TreeNode;

/**
 * 二叉树前序遍历
 *
 * @author osyuj
 */
public class Sample21 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        preOrder(node1);
        System.out.println("========");
        middleOrder(node1);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void middleOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        middleOrder(root.left);
        System.out.println(root.val);
        middleOrder(root.right);
    }
}