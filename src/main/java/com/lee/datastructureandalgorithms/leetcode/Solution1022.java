package com.lee.datastructureandalgorithms.leetcode;

/**
 * 从根到叶的二进制数之和
 *
 * @author D49450
 */
public class Solution1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}