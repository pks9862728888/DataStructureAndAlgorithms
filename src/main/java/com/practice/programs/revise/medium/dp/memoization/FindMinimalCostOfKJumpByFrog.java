package com.practice.programs.revise.medium.dp.memoization;

import java.util.Arrays;

public class FindMinimalCostOfKJumpByFrog {

    /**
     * A frog can make at most idx + 1, idx + 2,... idx + k jumps
     * Find minimal cost of jump to reach nth index
     * TC: O(n * k)
     * AS: O(n) for cache + O(n) for call stack
     * https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost
     * Concept:
     * DP
     * MEMOIZATION
     * BOUNDED_ITERATE_OVER_ALL_POSSIBLE_OPTION_PATTERN
     */
    public int minimizeCostMemoization(int arr[], int n, int k){
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return find(arr, n, k, 0, cache);
    }

    private int find(int[] arr, int n, int k, int idx, int[] cache) {
        if (idx == n - 1) {
            return 0;
        }
        if (cache[idx] == -1) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                int jumpIdx = idx + i;
                if (jumpIdx < n) {
                    int currCost = find(arr, n, k, jumpIdx, cache) + Math.abs(arr[idx] - arr[jumpIdx]);
                    minCost = Math.min(minCost, currCost);
                } else {
                    break;
                }
            }
            cache[idx] = minCost;
        }
        return cache[idx];
    }

    private int dpTabulation(int[] arr, int n, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int idx = 1; idx < n; idx++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int jumpIdx = idx - j;
                if (jumpIdx >= 0) {
                    int currCost = dp[jumpIdx] + Math.abs(arr[idx] - arr[jumpIdx]);
                    minCost = Math.min(minCost, currCost);
                } else {
                    break;
                }
            }
            dp[idx] = minCost;
        }
        return dp[n - 1];
    }
}
