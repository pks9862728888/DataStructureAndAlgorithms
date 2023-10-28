package com.practice.programs.revise.medium.tree;

/**
 * <a href="https://www.codingninjas.com/studio/problems/is-height-balanced-binary-tree_975497?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class IsBalancedBinaryTree {

    public static boolean isBalancedBT(TreeNode<Integer> root) {
        return isBalanced(root) != -1;
    }

    private static int isBalanced(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = isBalanced(root.left);
        if (leftHeight == -1) {
            return leftHeight;
        }
        int rightHeight = isBalanced(root.right);
        if (rightHeight == -1) {
            return rightHeight;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ?
                -1 : 1 + Math.max(leftHeight, rightHeight);
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
