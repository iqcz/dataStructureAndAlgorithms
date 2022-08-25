package com.lee.datastructureandalgorithms.leetcode;

/**
 * 合并二叉树
 * @author i324779
 */
public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode mergedTree = new TreeNode(root1.val + root2.val);
        mergedTree.left = this.mergeTrees(root1.left, root2.left);
        mergedTree.right = this.mergeTrees(root1.right, root2.right);
        return mergedTree;
    }
}
