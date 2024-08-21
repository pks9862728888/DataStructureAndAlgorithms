package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * TC: O(m * n), where m = no of nodes in root, n = no of nodes in subRoot
 * Concept:
 * TREE
 */
public class IsSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        boolean isSubTree = false;
        if (root.val == subRoot.val) {
            isSubTree = checkSubTree(root, subRoot);
        }
        isSubTree = isSubTree || isSubtree(root.left, subRoot);
        isSubTree = isSubTree || isSubtree(root.right, subRoot);
        return isSubTree;
    }

    private boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return checkSubTree(root.left, subRoot.left) && checkSubTree(root.right, subRoot.right);
    }
}
