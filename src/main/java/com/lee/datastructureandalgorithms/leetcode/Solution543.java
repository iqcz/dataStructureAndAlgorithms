package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二叉树的直径
 * @author i324779
 */
public class Solution543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth((root.right));
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
