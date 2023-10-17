package com.practice.programs.medium.tree;

/**
 * TC: O(n) AS: O(n) - recursion call stack for skewed tree
 */
class MirrorBinaryTree {

    public TreeNode mirrorBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        return root;
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
