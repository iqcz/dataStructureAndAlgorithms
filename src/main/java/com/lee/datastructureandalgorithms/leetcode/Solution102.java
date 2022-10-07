package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author D49450
 * 层序遍历
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获取每层节点的个数
            int levelNodeNumber = queue.size();
            List<Integer> subList = new LinkedList<>();
            // 处理本层节点，包括输出节点值和节点的左右子树入队
            for (int i = 0; i < levelNodeNumber; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(Objects.requireNonNull(queue.poll()).val);
            }
            result.add(subList);
        }
        return result;
    }
}