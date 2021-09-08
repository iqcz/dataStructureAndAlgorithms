package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.lee.datastructureandalgorithms.leetcode.TreeNode;

/**
 * 二叉树最小深度
 * 使用深度优先
 *                    1
 *                 /    \
 *                2      3
 *              /  \    /
 *             4    5  6
 *                    /
 *                   7
 * @author osyuj
 */
public class Sample17 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println("minDepth(node1) = " + minDepth(node1));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }

        return min + 1;
    }

}
