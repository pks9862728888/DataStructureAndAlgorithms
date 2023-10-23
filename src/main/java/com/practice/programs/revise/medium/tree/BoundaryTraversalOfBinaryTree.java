package com.practice.programs.revise.medium.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * TC: O(n), AS: O(n)
 */
class BoundaryTraversalOfBinaryTree {

    // NOTE: For left view
    // we have to go for left left left and not full in-order like we do for left view
    // because else for some inputs the solution does not work

    public ArrayList<Long> binaryTreeBoundaryTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Long> res = new ArrayList<>();
        if (!isLeafNode(root)) {
            res.add(root.val);
        }
        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundaryInReverse(root.right, res);
        return res;
    }

    private void addLeftBoundary(TreeNode curr, ArrayList<Long> res) {
        while (curr != null) {
            if (!isLeafNode(curr)) {
                res.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode curr, ArrayList<Long> res) {
        if (curr != null) {
            if (isLeafNode(curr)) {
                res.add(curr.val);
            } else {
                addLeaves(curr.left, res);
                addLeaves(curr.right, res);
            }
        }
    }

    private void addRightBoundaryInReverse(TreeNode curr, ArrayList<Long> res) {
        if (curr == null || isLeafNode(curr)) {
            return;
        }
        Stack<Long> tempStack = new Stack<>();
        while (curr != null) {
            if (!isLeafNode(curr)) {
                tempStack.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!tempStack.isEmpty()) {
            res.add(tempStack.pop());
        }
    }

    private boolean isLeafNode(TreeNode curr) {
        return curr.left == null && curr.right == null;
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
