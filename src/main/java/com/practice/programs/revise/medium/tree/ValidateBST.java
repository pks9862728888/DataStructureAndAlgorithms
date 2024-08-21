package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * TC: O (n), AS: O(height) -> O(n)
 * Concepts
 * TREE
 * BST
 */
class ValidateBST {

    boolean validateBinarySearchTree(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBst(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        } else if (!(root.val > minValue && root.val < maxValue)) {
            return false;
        }
        return isValidBst(root.left, minValue, root.val) &&
                isValidBst(root.right, root.val, maxValue);
    }
}
