package com.practice.programs.revise.medium.dp.memoization.boundedknapsack.skippattern;

import java.util.Arrays;

/**
 * 2 5 1 3 6 2 4, ans = 15
 * DP (memoization)
 * TC: O(n), AS: O(n)
 */
public class FindMaxWealthStolenByKalia {

    public static long houseThief(int n, int []arr) {
        long[] cache = new long[n + 1];
        Arrays.fill(cache, -1);
        return loot(n, arr, 0, cache);
    }

    private static long loot(int n, int[] arr, int currIdx, long[] cache) {
        if (currIdx >= n) {
            return 0;
        }
        if (cache[currIdx] == -1) {
            long takeLoot = loot(n, arr, currIdx + 2, cache) + arr[currIdx];
            long dontTakeLoot = loot(n, arr, currIdx + 1, cache);
            cache[currIdx] = Math.max(takeLoot, dontTakeLoot);
        }
        return cache[currIdx];
    }
}
