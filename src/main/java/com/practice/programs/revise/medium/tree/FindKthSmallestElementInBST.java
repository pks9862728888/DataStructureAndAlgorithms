package com.practice.programs.revise.medium.tree;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FindKthSmallestElementInBST {

    // If we were to find Kth largest we would have traversed, right, root, left

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallestIterativeApproach(root, k);
//        return kthSmallestRecursive(root, k);
    }

    public static int kthSmallestIterativeApproach(TreeNode root, int k) {
        int kthSmallest = -1;
        if (root == null) {
            return kthSmallest;
        }
        Stack<TreeNode> st = new Stack<>();  // Iterative in-order traversal
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            k--;
            if (k == 0) {
                kthSmallest = (int) curr.val;
                break;
            }
            curr = curr.right;
        }
        return kthSmallest;
    }

    public static int kthSmallestRecursive(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger(0);
        return (int) kthSmallest(root, k, count);
    }

    private static long kthSmallest(TreeNode root, int k, AtomicInteger count) {
        if (root == null) {
            return -1;
        }
        long kthSmallest = kthSmallest(root.left, k, count);
        if (count.get() == k) {
            return kthSmallest;
        }
        count.getAndIncrement();
        kthSmallest = root.val;
        if (count.get() == k) {
            return kthSmallest;
        }
        return kthSmallest(root.right, k, count);
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
