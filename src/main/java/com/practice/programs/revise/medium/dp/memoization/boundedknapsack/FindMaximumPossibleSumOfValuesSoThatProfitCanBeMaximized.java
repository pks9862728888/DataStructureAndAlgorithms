package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.Arrays;

/**
 * TC: O(items * maxWt)
 * AS: O(items * maxWt)
 */
public class FindMaximumPossibleSumOfValuesSoThatProfitCanBeMaximized {

    /**
     * There are N items, numbered 0, 2,..., N-1. For each i (0 ≤ i ≤ N-1), item i has a weight of w[i] and a value of v[i].
     * You have decided to choose some of the N items and carry them home in a sack.
     * The capacity of the sack is W, which means that the sum of the weights of items taken must be at most W.
     * Find the maximum possible sum of the values of items that you can take home.
     */
    static long maxValue(int w, long wt[], long val[]){
        int n = wt.length;
        long[][] cache = new long[n + 1][w + 1];
        for (long[] row: cache) {
            Arrays.fill(row, -1);
        }
        return findMaxVal(w, wt, val, n, 0, cache);
    }

    private static long findMaxVal(
            long w, long wt[], long val[], int n, int currIdx, long[][] cache) {
        if (currIdx == n) {
            return 0;
        }
        if (getValueFromCache(cache, currIdx, w) != -1L) {
            return getValueFromCache(cache, currIdx, w);
        }

        long maxValTake = w - wt[currIdx] >= 0 ?
                findMaxVal(w - wt[currIdx], wt, val, n, currIdx + 1, cache) + val[currIdx] : 0;
        long maxValDontTake = findMaxVal(w, wt, val, n, currIdx + 1, cache);

        long maxVal = Math.max(maxValTake, maxValDontTake);
        setValueInCache(cache, currIdx, w, maxVal);
        return maxVal;
    }

    private static long getValueFromCache(long[][] cache, int currIdx, long w) {
        return cache[currIdx][(int) w];
    }

    private static void setValueInCache(long[][] cache, int currIdx, long w, long value) {
        cache[currIdx][(int) w] = value;
    }
}
