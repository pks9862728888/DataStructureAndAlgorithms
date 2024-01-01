package com.practice.programs.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/symmetric-tree_981177?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * <a href="https://leetcode.com/problems/symmetric-tree/">Leetcode practice link</a>
 */
class SymmetricBinaryTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null || left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
