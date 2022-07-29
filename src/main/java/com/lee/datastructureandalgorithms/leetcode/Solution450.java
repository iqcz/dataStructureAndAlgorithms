package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 如果目标节点小于当前根节点，则去左子树中删除
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) { // 如果目标节点大于当前根节点，则去右子树中删除
            root.right = deleteNode(root.right, key);
        } else { // 找到了当前节点
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else { // 当前节点的左右子树都不为空
                // 寻找当前右子树的最左节点
                TreeNode rightMain = root.right;
                while (rightMain.left != null) {
                    rightMain = rightMain.left;
                }
                // 当前节点左子树成为其右子树的最左节点的左子树
                rightMain.left = root.left;
                // 当前节点的右子树顶替其位置，节点被删除
                root = root.right;
            }
        }
        return root;
    }
}
