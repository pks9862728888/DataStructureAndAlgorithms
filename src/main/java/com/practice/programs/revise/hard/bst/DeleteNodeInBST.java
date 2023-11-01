package com.practice.programs.revise.hard.bst;

/**
 * TC: O(h), AS: O(h) -> call stack
 * <a href="https://www.codingninjas.com/studio/problems/delete-node-in-bst_920381?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findMinValue(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private static int findMinValue(TreeNode root) {
        int minValue = root.val;
        while (root != null) {
            if (root.val < minValue) {
                minValue = root.val;
            }
            root = root.left;
        }
        return minValue;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
