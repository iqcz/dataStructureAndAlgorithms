package com.lee.datastructureandalgorithms.zuo;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class Demo07 {

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        Map<Integer, Integer> valueIndexMap = new HashMap<>(16);
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }

        return f(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    private static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2,
                              Map<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }

        TreeNode root = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return root;
        }
        int find = valueIndexMap.get(pre[L1]);
        root.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        root.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return root;
    }
}
