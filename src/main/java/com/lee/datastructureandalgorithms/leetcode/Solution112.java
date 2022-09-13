package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;

        // 递归出口，一般都是叶子节点或空节点。
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
