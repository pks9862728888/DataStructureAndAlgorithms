package com.practice.programs.revise.medium.greedyalgorithms;

public class JumpGame {

    // from idx i, user, can take upto i, i + 1, i + 2, .... i + nums[i] jumps
    // Find if user can reach end from start
    // 4, 0, 0, 0, 4 -> true
    // 3, 0, 0, 0, 4 -> false
    // Use greedy approach, TC: O(n), AS: O(1)
    public String canJump(int[] nums) {
        int currIdx = nums.length - 1;
        for (int prevIdx = currIdx - 1; prevIdx >= 0; prevIdx--) {
            if (prevIdx + nums[prevIdx] >= currIdx) {
                currIdx = prevIdx;
            }
        }
        return String.valueOf(currIdx == 0);
    }

    /**
     * https://leetcode.com/problems/jump-game/
     * From each idx you can jump only upto a fixed length specified by idx[i]
     * Concept:
     * DP
     * BOUNDED_ITERATE_OVER_ALL_POSSIBLE_OPTION_PATTERN
     */
    public boolean canJumpII(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return canJump(nums, 0, nums.length, cache);
    }

    private boolean canJump(int[] nums, int idx, int n, Boolean[] cache) {
        if (idx >= n - 1) {
            return true;
        }
        if (cache[idx] == null) {
            boolean canReachEnd = false;
            int jumpLen = nums[idx];
            for (int jl = 1; jl <= jumpLen; jl++) {
                canReachEnd = canReachEnd || canJump(nums, idx + jl, n, cache);
            }
            cache[idx] = canReachEnd;
        }
        return cache[idx];
    }
}
