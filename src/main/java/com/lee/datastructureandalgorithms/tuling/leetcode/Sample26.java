package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.google.common.collect.Lists;
import com.lee.datastructureandalgorithms.leetcode.TreeNode;

import java.util.List;

/**
 * 二叉树遍历，层次遍历
 * 使用递归方式
 *
 * @author osyuj
 */
public class Sample26 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        List<Integer> list = Lists.newArrayList();
        leverOrder(node1, 1, list);
        System.out.println("list = " + list);
    }

    /**
     *
     * @param root
     * @param i 下标
     * @param list
     */
    private static void leverOrder(TreeNode root, int i, List<Integer> list) {
        if (root == null) {
            return;
        }
        int length = list.size();
        // 先填充元素
        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        leverOrder(root.left, 2 * i, list);
        leverOrder(root.right, 2 * i + 1, list);
    }
}