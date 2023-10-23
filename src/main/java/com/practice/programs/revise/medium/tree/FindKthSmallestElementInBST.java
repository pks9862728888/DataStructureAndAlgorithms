package com.practice.programs.revise.medium.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TC: O(n), AS: O(n)
 */
class FindKthSmallestElementInBST {

    // If we were to find Kth largest we would have traversed, right, root, left

    public int kthSmallestElementInABst(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger(0);
        return (int) kthSmallest(root, k, count);
    }

    private long kthSmallest(TreeNode root, int k, AtomicInteger count) {
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
