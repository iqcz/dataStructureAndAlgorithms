package com.lee.datastructureandalgorithms.leetcode;

/**
 * 对称二叉树
 *
 * @author D49450
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return deepCheck(root.left, root.right);
    }

    private boolean deepCheck(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return deepCheck(left.left, right.right) && deepCheck(left.right, right.left);
    }
    // 还可以借助队列来实现
}
