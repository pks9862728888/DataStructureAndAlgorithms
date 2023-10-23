package com.practice.programs.revise.medium.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(n), AS: O(n)
 */
class BalanceBST {

    // Convert BST into array by traversing in-order
    // Get mid as root, and do the same in left and right half

    public TreeNode balanceBST(TreeNode root) {
        List<Long> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return balanceBST(sortedList, 0, sortedList.size() - 1);
    }

    private TreeNode balanceBST(List<Long> sortedList, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = balanceBST(sortedList, st, mid - 1);
        root.right = balanceBST(sortedList, mid + 1, end);
        return root;
    }

    private void inOrderTraversal(TreeNode root, List<Long> sortedList) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, sortedList);
        sortedList.add(root.val);
        inOrderTraversal(root.right, sortedList);
    }

    private static class TreeNode {
        public long val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(long x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
