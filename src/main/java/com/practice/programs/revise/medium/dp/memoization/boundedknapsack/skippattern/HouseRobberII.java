package com.practice.programs.revise.medium.dp.memoization.boundedknapsack.skippattern;

import java.util.Arrays;

/**
 * Find max wealth stolen by Kalia
 * He can't rob two adjacent house.
 * Houses are connected together in circular fashion, so first and last house can't be robbed together
 * https://leetcode.com/problems/house-robber-ii/
 * TC: O(n), AS: O(n) + O(n)
 * Concept:
 * DP
 * MEMOIZATION
 * BOUNDED_ZERO_ONE_KNAPSACK_JUMP_PATTERN
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // Find max of first half skipping last element, and second half skipping first element
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int st, int end) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return rob(nums, st, end, cache);
    }

    private int rob(int[] nums, int idx, int n, int[] cache) {
        if (idx > n) {
            return 0;
        }
        if (cache[idx] == -1) {
            int dontRob = rob(nums, idx + 1, n, cache);
            int rob = rob(nums, idx + 2, n, cache) + nums[idx];
            cache[idx] = Math.max(rob, dontRob);
        }
        return cache[idx];
    }
}
