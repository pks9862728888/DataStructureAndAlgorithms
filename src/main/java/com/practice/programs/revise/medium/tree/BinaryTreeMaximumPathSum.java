package com.practice.programs.revise.medium.tree;

import com.practice.programs.revise.medium.utils.TreeNode;

import java.util.concurrent.atomic.AtomicReference;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * TC: O(n), AS: O(height)
 * Concepts:
 * TREE
 * TREE_MAX_PATH_SUM
 * Max path sum can be Max of [curr node val, curr node + left sum, curr node + right sum]
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        AtomicReference<Integer> maxPathSumRef = new AtomicReference<>(null);
        getMaxPathSum(root, maxPathSumRef);
        return maxPathSumRef.get() == null ? 0 : maxPathSumRef.get();
    }

    private int getMaxPathSum(TreeNode root, AtomicReference<Integer> maxPathSumRef) {
        if (root == null) {
            return 0;
        }
        // find sum from right & left subtree
        int leftSum = getMaxPathSum(root.left, maxPathSumRef);
        int rightSum = getMaxPathSum(root.right, maxPathSumRef);
        // curr sum (max of currNode val, nodeVal + maxSum from right / left subtree)
        int currPathSum = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        // Max path sum
        int currMaxPathSum = Math.max(root.val + rightSum + leftSum, currPathSum);
        int maxPathSum = maxPathSumRef.get() == null ?
                currMaxPathSum : Math.max(currMaxPathSum, maxPathSumRef.get());
        maxPathSumRef.set(maxPathSum);
        return currPathSum;
    }
}
