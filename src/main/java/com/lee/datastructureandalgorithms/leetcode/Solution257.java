package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 深度优先遍历
 * 广度优先遍历：维护一个队列
 *
 * @author D49450
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    /**
     * 深度优先遍历
     * @param root
     * @param path
     * @param paths
     */
    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append(root.val);
        // 当前节点是叶子节点
        if (root.left == null && root.right == null) {
            paths.add(stringBuilder.toString());
        } else { // 不是叶子节点，继续遍历
            stringBuilder.append("->");
            constructPaths(root.left, stringBuilder.toString(), paths);
            constructPaths(root.right, stringBuilder.toString(), paths);
        }
    }
}
