package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * TC: O(n), AS: O(h) -> recursion stack, where h = height of tree
 * Concepts:
 * TREE
 */
public class CheckIdenticalTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        }
        boolean res = isSameTree(p.left, q.left);
        return res && isSameTree(p.right, q.right);
    }
}
