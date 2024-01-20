package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二叉搜索树中的排序
 *
 * @author alphayosemite
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        return this.searchBST(val < root.val ? root.left : root.right, val);
    }
}
