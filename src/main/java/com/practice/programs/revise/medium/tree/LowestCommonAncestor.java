package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

/**
 * TC: O(n), AS: O(n)
 */
public class LowestCommonAncestor {

    // For ancestor we consider the node itself as ancestor
    // In lca.png screenshot, LCA of 8 & 9 is 3

    TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
