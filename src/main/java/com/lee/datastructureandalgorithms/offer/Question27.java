package com.lee.datastructureandalgorithms.offer;

import com.lee.datastructureandalgorithms.leetcode.TreeNode;

/**
 * 完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author i324779
 */
public class Question27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
