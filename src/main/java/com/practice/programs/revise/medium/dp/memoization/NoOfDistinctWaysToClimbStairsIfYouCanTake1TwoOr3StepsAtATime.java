package com.practice.programs.revise.medium.dp.memoization;

import java.util.Arrays;

/**
 * DP (bruteforce), TC: O(3^n), AS: O(n)
 * DP (memoization), TC: O(n), AS: O(n)
 */
public class NoOfDistinctWaysToClimbStairsIfYouCanTake1TwoOr3StepsAtATime {

    private static final long MOD = 1000000007;

    int numberOfWays(int n) {
        long[] cache = new long[n + 1];
        Arrays.fill(cache, -1);
        return (int) noOfWays(n, cache);
    }

    private long noOfWays(int n, long[] cache) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        if (cache[n] == -1) {
            cache[n] = ((noOfWays(n - 1, cache) + noOfWays(n - 2, cache)) % MOD +
                    noOfWays(n - 3, cache)) % MOD;
        }
        return cache[n];
    }
}
