package com.lee.datastructureandalgorithms.leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author D49450
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;

        // 递归出口，一般都是叶子节点或空节点。
        if ((root.left == null) && (root.right == null)) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 迭代
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.addLast(new Pair<>(root, sum - root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.removeLast();
            TreeNode node = top.getKey();
            int remain = top.getValue();

            if ((node.right == null) && (node.left == null) && (remain == 0)) {
                return true;
            }
            if (node.right != null) {
                stack.addLast(new Pair<>(node.right, remain - node.right.val));
            }
            if (node.left != null) {
                stack.addLast(new Pair<>(node.left, remain - node.left.val));
            }
        }

        return false;
    }
}
