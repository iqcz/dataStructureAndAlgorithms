package com.lee.datastructureandalgorithms.leetcode;

public class Solution404 {
    private int result;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return result;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeft) {
            result += root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
