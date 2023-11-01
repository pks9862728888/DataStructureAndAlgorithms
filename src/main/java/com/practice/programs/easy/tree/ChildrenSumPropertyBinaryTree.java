package com.practice.programs.easy.tree;

/**
 * Return true if root node sum = sum of child nodes for all non-leaf nodes
 * TC: O(n), AS: O(height of BT)
 * <a href="https://www.codingninjas.com/studio/problems/children-sum-property_8357239?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class ChildrenSumPropertyBinaryTree {

    public static boolean isParentSum(Node root) {
        if (root == null || isLeafNode(root)) {
            return true;
        }
        if (root.data != getChildNodeSum(root)) {
            return false;
        }
        boolean isParentSum = isParentSum(root.left);
        return isParentSum && isParentSum(root.right);
    }

    private static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static int getChildNodeSum(Node root) {
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        return sum;
    }

    private static class Node {
        public int data;
        public Node left;
        public Node right;
    }
}
