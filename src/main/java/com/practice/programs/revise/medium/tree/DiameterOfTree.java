package com.practice.programs.revise.medium.tree;

/**
 * TC: O(n), AS: O(n) - skewed binary tree for stack space
 */
class DiameterOfTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return findDia(root).dia;
    }

    private DiaHeight findDia(TreeNode root) {
        if (root == null) {
            return new DiaHeight(0, 0);
        }
        DiaHeight leftDia = findDia(root.left);
        DiaHeight rightDia = findDia(root.right);
        int currHeight = 1 + Math.max(leftDia.height, rightDia.height);
        int currDia = leftDia.height + rightDia.height;
        int dia = Math.max(currDia, Math.max(leftDia.dia, rightDia.dia));
        return new DiaHeight(dia, currHeight);
    }

    private static class DiaHeight {
        int dia;
        int height;
        DiaHeight(int dia, int height) {
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
