package com.practice.programs.revise.medium.dp.memoization.boundedknapsack.skippattern;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iii/
 * Houses are like binary tree. If parent is robbed, child node cant be robbed
 * Find max profit
 * TC: O(n),
 * AS: O(log h) where h = height of BT
 * Concept:
 * BOUNDED_ZERO_ONE_KNAPSACK_JUMP_PATTERN
 * BINARY_TREE
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        Map<String, Integer> cache = new HashMap<>();
        return rob(root, true, cache);
    }

    private int rob(TreeNode curr, boolean canRob, Map<String, Integer> cache) {
        if (curr == null) {
            return 0;
        }
        String key = getKey(curr, canRob);
        if (!cache.containsKey(key)) {
            // don't take scenario
            int dontTakeLeftRes = rob(curr.left, true, cache);
            int dontTakeRightRes = rob(curr.right, true, cache);
            int res = dontTakeLeftRes + dontTakeRightRes;
            // take scenario
            if (canRob) {
                int leftRes = rob(curr.left, false, cache);
                int rightRes = rob(curr.right, false, cache);
                int totalTake = leftRes + rightRes + curr.val;
                res = Math.max(res, totalTake);
            }
            cache.put(key, res);
        }
        return cache.get(key);
    }

    private String getKey(TreeNode curr, boolean canRob) {
        return curr.toString() + "#" + canRob;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
