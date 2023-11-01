package com.practice.programs.easy.bst;

/**
 * TC: O(h), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class CeilInBST {

    public static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = Integer.MAX_VALUE;
        while (node != null) {
            if (node.data >= x && node.data < ceil) {
                ceil = node.data;
            }
            if (x < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ceil == Integer.MAX_VALUE ? -1 : ceil;
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
    }
}
