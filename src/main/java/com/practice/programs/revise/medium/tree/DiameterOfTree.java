package com.practice.programs.revise.medium.tree;

/**
 * TC: O(n), AS: O(n) - skewed binary tree for stack space
 */
class DiameterOfTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return findDia(root).dia;
    }

    private DiaHeightPair findDia(TreeNode root) {
        if (root == null) {
            return new DiaHeightPair(0, 0);
        }
        DiaHeightPair leftPair = findDia(root.left);
        DiaHeightPair rightPair = findDia(root.right);
        int currHeight = 1 + Math.max(leftPair.height, rightPair.height);
        int currDia = leftPair.height + rightPair.height;
        int overallDia = Math.max(currDia, Math.max(leftPair.dia, rightPair.dia));
        return new DiaHeightPair(overallDia, currHeight);
    }

    private static class DiaHeightPair {
        int dia;
        int height;
        DiaHeightPair(int dia, int height) {
            this.dia = dia;
            this.height = height;
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
