package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.lee.datastructureandalgorithms.leetcode.TreeNode;

/**
 * 广度优先遍历
 *
 * @author osyuj
 */
public class QueueNode {
    TreeNode treeNode;
    int depth;

    public QueueNode(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }
}