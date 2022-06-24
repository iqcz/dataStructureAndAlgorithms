package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二叉树的最大深度
 *
 * @author D49450
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
