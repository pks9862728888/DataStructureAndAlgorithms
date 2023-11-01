package com.practice.programs.easy.bst;

/**
 * TC: O(h), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/floor-from-bst_625868?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FloorInBST {

    public static int floor(BinaryTreeNode<Integer> node, int k) {
        int floor = Integer.MIN_VALUE;
        while (node != null) {
            if (node.data == k) {
                return k;
            } else if (node.data <= k && node.data > floor) {
                floor = node.data;
            }
            if (k <= node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return floor;
    }

    private static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }
}
