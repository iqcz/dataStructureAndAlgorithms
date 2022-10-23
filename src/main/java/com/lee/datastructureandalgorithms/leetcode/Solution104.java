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

    /**
     * 最小深度
     *
     * @param root 树
     * @return 树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? (left + right + 1) : (Math.min(left, right) + 1);
    }
}
