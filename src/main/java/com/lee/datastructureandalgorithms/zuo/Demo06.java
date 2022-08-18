package com.lee.datastructureandalgorithms.zuo;

/**
 * maximum depth of binary tree
 * @author i324779
 */
public class Demo06 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
