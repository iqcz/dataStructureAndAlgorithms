package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.google.common.collect.Lists;
import com.lee.datastructureandalgorithms.leetcode.TreeNode;

import java.util.Queue;

/**
 * 二叉树最小深度
 * 最小深度：从根节点到最近叶子节点得最短路径上的节点数量
 * <p>
 * 使用深度优先
 * 1
 * /    \
 * 2      3
 * /  \    /
 * 4    5  6
 * /
 * 7
 *
 * @author D49450
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
        System.out.println("minDepth1(node1) = " + minDepth1(node1));
    }

    /**
     * 深度优先
     * 遍历整颗数，找到每一个叶子节点，从叶子节点往上开始计算，左右子节点都为空则记录深度为1
     * 左右子节点只有一边，深度记录为子节点深度+1
     * 左右两边都有子节点，则记录左右子节点的深度较小值+1
     *
     * @param root
     * @return
     */

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
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

    /**
     * 广度优先
     * 从上往下，找到一个节点时，标记这个节点的深度。查看该节点是否为叶子节点，如果是直接返回深度
     * 如果不是叶子节点，将其子节点标记深度(在父节点深度的基础上加1)，再判断该节点是否为叶子节点
     */
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = Lists.newLinkedList();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode node = queueNode.treeNode;
            int depth = queueNode.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }
}
