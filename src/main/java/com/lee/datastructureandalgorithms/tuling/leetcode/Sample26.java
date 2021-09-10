package com.lee.datastructureandalgorithms.tuling.leetcode;

import com.lee.datastructureandalgorithms.leetcode.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树遍历，层次遍历
 * 使用递归方式
 *
 * @author osyuj
 */
public class Sample26 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param root
     * @param i 下标
     * @param list
     */
    private static void leverOrder(TreeNode root, int i, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        int length = list.size();
        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        leverOrder(root.left, 2 * i, list);
        leverOrder(root.right, 2 * i + 1, list);
    }
}