package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 寻找左子树最右节点
                TreeNode mostRightNode = root.left;
                while (mostRightNode.right != null) {
                    mostRightNode = mostRightNode.right;
                }
                // 将原来右子树挂到左子树最右节点的右指针上
                mostRightNode.right = root.right;
                // 将左子树挂到root节点的右指针上
                root.right = root.left;
                root.left = null;
                // 此时root的左子树已经为null，继续向下寻找，是否还有存在的左子树，重复上述过程
                root = root.right;
            }
        }
    }
}
