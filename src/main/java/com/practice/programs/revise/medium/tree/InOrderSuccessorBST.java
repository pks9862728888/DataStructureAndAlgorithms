package com.practice.programs.revise.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Brute: TC: O(n), AS: O(n) + O(height) - extra space to store inOrder + stack space
 * In-Order: O(n), AS: O(height) - call stack
 * Optimal: O(h), AS: O(1)
 */
public class InOrderSuccessorBST {

    public int inorderSuccessor(TreeNode root, TreeNode givenNode) {
        // return inOrderSuccessorBrute(root, givenNode);
        // return inOrderSuccessorInOrderSearch(root, givenNode);
        return inorderSuccessorOptimal(root, givenNode);
    }

    private int inorderSuccessorOptimal(TreeNode curr, TreeNode givenNode) {
        TreeNode successor = null;
        boolean nodeFound = false;
        while (curr != null) {
            if (curr == givenNode) {
                curr = curr.right;
                nodeFound = true;
            } else if (curr.val > givenNode.val) {
                successor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            if (nodeFound && curr != null && curr.val > givenNode.val && (successor == null || curr.val < successor.val)) {
                successor = curr;
            }
        }
        if (nodeFound) {
            return successor == null ? -1 : (int) successor.val;
        } else {
            return -1;
        }
    }

    private int inOrderSuccessorInOrderSearch(TreeNode root, TreeNode givenNode) {
        AtomicBoolean found = new AtomicBoolean(false);
        AtomicReference<TreeNode> successorNode = new AtomicReference<>(null);
        inOrderSuccessorInOrderSearch(root, givenNode, found, successorNode);
        return successorNode.get() == null ? -1 : (int) successorNode.get().val;
    }

    private void inOrderSuccessorInOrderSearch(
            TreeNode curr, TreeNode givenNode, AtomicBoolean found, AtomicReference<TreeNode> successorNode) {
        if (curr == null) {
            return;
        }
        inOrderSuccessorInOrderSearch(curr.left, givenNode, found, successorNode);
        if (curr == givenNode) {
            found.set(true);
        } else if (found.get()) {
            if (curr.val > givenNode.val) {
                if (successorNode.get() == null || curr.val < successorNode.get().val) {
                    successorNode.set(curr);
                }
            }
        }
        inOrderSuccessorInOrderSearch(curr.right, givenNode, found, successorNode);
    }

    private int inOrderSuccessorBrute(TreeNode root, TreeNode givenNode) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        int nodeIdx = traverseInorderAndGiveNodeIdx(root, givenNode, inOrder);
        if (nodeIdx == -1) {
            return -1;
        }
        nodeIdx++;
        return nodeIdx >= inOrder.size() ? -1 : inOrder.get(nodeIdx);
    }

    private int traverseInorderAndGiveNodeIdx(TreeNode curr, TreeNode givenNode, ArrayList<Integer> inOrder) {
        if (curr == null) {
            return -1;
        }
        int givenNodeIdx = traverseInorderAndGiveNodeIdx(curr.left, givenNode, inOrder);
        inOrder.add((int) curr.val);
        if (curr == givenNode) {
            givenNodeIdx = inOrder.size() - 1;
        }
        int rightIdx = traverseInorderAndGiveNodeIdx(curr.right, givenNode, inOrder);
        return givenNodeIdx == -1 ? rightIdx : givenNodeIdx;
    }

    private static class TreeNode {
        public long val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;
        public TreeNode (long x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }
}
