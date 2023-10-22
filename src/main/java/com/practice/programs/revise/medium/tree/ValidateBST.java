package com.practice.programs.revise.medium.tree;

/**
 * TC: O (n), AS: O(height) -> O(n)
 */
class ValidateBST {

    boolean validateBinarySearchTree(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBst(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (!(root.val > minValue && root.val < maxValue)) {
            return false;
        }
        boolean isValid = isValidBst(root.left, minValue, root.val);
        isValid = isValid && isValidBst(root.right, root.val, maxValue);
        return isValid;
    }

    private static class TreeNode {
        public long val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode (long x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
