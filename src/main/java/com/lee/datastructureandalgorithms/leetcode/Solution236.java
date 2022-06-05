package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 * 二叉树的最近公共祖先
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到p或者所在节点，终止递归；或者找到叶子节点也没有就找到p或者q
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}