package com.lee.datastructureandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉树的锯齿形层序遍历
 * @author D49450
 * yl03870
 * a553221
 * i324779
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }

    private void travel(TreeNode root, List<List<Integer>> result, int height) {
        if (root == null) {
            return;
        }

        // 新的层需要增加新的子List
        if (height >= result.size()) {
            result.add(new LinkedList<>());
        }

        List<Integer> subList = result.get(height);
        // 因为要锯齿形层序遍历，所以对层高需要进行判断
        // 如果是从左到右，按普通的尾部追加节点即可
        // 如果是从右到左，使用头插法增加节点
        if (height % 2 == 0) {
            subList.add(root.val);
        } else {
            subList.add(0, root.val);
        }

        travel(root.left, result, height + 1);
        travel(root.right, result, height + 1);
    }
}