package com.practice.programs.revise.medium.dp.memoization;

import java.util.Arrays;

public class NoOfDistinctWaysToClimbStairsIfYouCanTake1Or2StepsAtATime {

    /**
     * DP memoization
     * TC: O(n), AS: O(1)
     */
    public int climbingStairs(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return climbingStairs(n, cache);
    }

    public int climbingStairs(int n, int[] cache) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        if (cache[n] == -1) {
            cache[n] = climbingStairs(n - 1, cache) + climbingStairs(n - 2, cache);
        }
        return cache[n];
    }

    /**
     * Iterative approach,
     * TC: O(n), AS: O(1)
     */
    // public int climbingStairs(int n) {
    //     if (n <= 2) {
    //         return n;
    //     }
    //     int a = 1;
    //     int b = 2;
    //     int c = 0;
    //     for (int i = 3; i <= n; i++) {
    //         c = a + b;
    //         a = b;
    //         b = c;
    //     }
    //     return c;
    // }
}
