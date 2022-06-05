package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 * 验证二叉搜索树
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        // 中止条件：要么是根节点本身为null；要么是递归到了叶子节点
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}