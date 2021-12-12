package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 * @author D49450
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        accessTree(root, result);
        return result;
    }

    private void accessTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        accessTree(root.left, result);
        result.add(root.val);
        accessTree(root.right, result);
    }

    public List<Integer> inorderTraversalWithLoop(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
