package com.lee.datastructureandalgorithms.leetcode;

/**
 * @author D49450
 */
public class Solution235 {
    // 3月27日， 临时解封。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
     * 利用二叉搜索树的特性
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
