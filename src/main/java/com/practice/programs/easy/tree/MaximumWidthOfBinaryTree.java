package com.practice.programs.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/maximum-width-in-binary-tree_763671?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class MaximumWidthOfBinaryTree {

    public static int getMaxWidth(TreeNode root) {
        int maxWidth = 0;
        if (root == null) {
            return maxWidth;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int currLevelWidth = q.size();
            maxWidth = Math.max(maxWidth, currLevelWidth);
            for (int i = 1; i <= currLevelWidth; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return maxWidth;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
