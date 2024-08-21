package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class FindKthSmallestElementInBST {

    // If we were to find Kth largest we would have traversed, right, root, left

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallestIterative(root, k);
//        return kthSmallestRecursive(root, k);
    }

    private static int kthSmallestIterative(TreeNode root, int k) {
        if (root == null) return -1;
        int kthSmallest = -1;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            if (--k == 0) {
                kthSmallest = curr.val;
                break;
            }
            curr = curr.right;
        }
        return kthSmallest;
    }

    public static int kthSmallestRecursive(TreeNode root, int k) {
        AtomicInteger curr = new AtomicInteger(0);
        AtomicReference<Integer> kthSmallest = new AtomicReference<>();
        find(root, curr, k, kthSmallest);
        return kthSmallest.get();
    }

    private static boolean find(TreeNode root, AtomicInteger currIdx, int k, AtomicReference<Integer> kthSmallest) {
        if (root == null) {
            return false;
        }
        boolean isFound = find(root.left, currIdx, k, kthSmallest);
        if (!isFound) {
            int curr = currIdx.incrementAndGet();
            if (curr == k) {
                isFound = true;
                kthSmallest.set(root.val);
            }
        }
        isFound = isFound || find(root.right, currIdx, k, kthSmallest);
        return isFound;
    }
}
