package com.lee.datastructureandalgorithms.leetcode;

/**
 * 二叉树的最小深度
 *
 * @author i324779
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null
                ?
                m1 + m2 + 1
                :
                Math.min(m1, m2) + 1;
    }
}
