package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.Objects;

public class FindSubsetPossibleWithGivenSum {

    /**
     * TC: O(n * sum), AS: (n * s)
     * Pattern: BOUNDED_ZERO_ONE_KNAPSACK
     */
    static boolean subsetSum(int a[], int sum) {
        int n = a.length;
        Boolean[][] cache = new Boolean[sum + 1][n + 1];
        return isSubsetPossible(a, sum, n, 0, cache);
    }

    private static boolean isSubsetPossible(
            int[] a, int sum, int n, int idx, Boolean[][] cache) {
        if (sum == 0) {
            return true;
        }
        if (idx == n || sum < 0) {
            return false;
        }
        if (Objects.isNull(cache[sum][idx])) {
            boolean outcomeTake = isSubsetPossible(a, sum - a[idx], n, idx + 1, cache);
            boolean outcomeDontTake = outcomeTake || isSubsetPossible(a, sum, n, idx + 1, cache);
            cache[sum][idx] = outcomeTake || outcomeDontTake;
        }
        return cache[sum][idx];
    }
}
