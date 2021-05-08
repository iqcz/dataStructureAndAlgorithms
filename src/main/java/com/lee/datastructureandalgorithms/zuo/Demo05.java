package com.lee.datastructureandalgorithms.zuo;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Demo05 {

    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
