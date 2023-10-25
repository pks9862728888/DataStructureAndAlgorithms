package com.practice.programs.revise.medium.tree;

/**
 * TC: O(h), AS: O(h) - call stack
 */
class LowestCommonAncestorBST {

    // For ancestor we consider the node itself as ancestor
    // In lca.png screenshot, LCA of 8 & 9 is 3

    public TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = (p.val <= root.val || q.val <= root.val) ? lowestCommonAncestorInBST(root.left, p, q) : null;
        TreeNode right = (p.val > root.val || q.val > root.val) ? lowestCommonAncestorInBST(root.right, p, q) : null;
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
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
