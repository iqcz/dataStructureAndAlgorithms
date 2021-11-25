package com.lee.datastructureandalgorithms.leetcode;


/**
 * Definition for a binary tree node.
 *
 * @author D49450
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    int deep;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
