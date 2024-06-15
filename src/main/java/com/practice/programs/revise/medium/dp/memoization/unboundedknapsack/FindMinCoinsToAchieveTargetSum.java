package com.practice.programs.revise.medium.dp.memoization.unboundedknapsack;

import java.util.Arrays;

public class FindMinCoinsToAchieveTargetSum {

    /**
     * TC: O(amount * coins), AS: O(amount * coins)
     * concepts:
     * TABULATION
     * UNBOUNDED_ZERO_ONE_KNAPSACK_SHOWING_OUTCOME_NOT_POSSIBLE
     * Sample Input
     * 5 25
     * 4 5 2 1 9
     * Sample Output
     * 4
     * Explanation
     * The optimal selection would be - two 9-valued coins, one coin each of value 5 and 2.
     */
    private static int minCoinsTabulized(int[] coins, int amount) {
        int n = coins.length;
        int[][] cache = new int[n][amount + 1];
        for (int idx = 0; idx < n; idx++) {
            for (int amt = 0; amt <= amount; amt++) {
                if (idx == 0) {
                    cache[0][amt] = amt % coins[idx] == 0 ? amt / coins[idx] : Integer.MAX_VALUE;
                } else {
                    int dontTake = cache[idx - 1][amt];
                    int take = coins[idx] <= amt ? cache[idx][amt - coins[idx]] : Integer.MAX_VALUE;
                    if (take != Integer.MAX_VALUE) {
                        take++;
                    }
                    cache[idx][amt] = Math.min(take, dontTake);
                }
            }
        }
        int res = cache[n - 1][amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    /**
     * TC: O(amount * coins), AS: O(amount * coins)
     */
    static int minCoinsMemoization(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[][] cache = new int[amount + 1][coins.length + 1];
        for (int[] row: cache) Arrays.fill(row, -1);
        int minCoins = minCoinsMemoization(coins, amount, 0, cache);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private static int minCoinsMemoization(int[] coins, int amt, int idx, int[][] cache) {
        if (amt == 0) {
            return 0;
        }
        if (idx == coins.length || amt < 0) {
            return Integer.MAX_VALUE;
        }
        if (cache[amt][idx] == -1) {
            int take = minCoinsMemoization(coins, amt - coins[idx], idx, cache);
            if (take != Integer.MAX_VALUE) {
                take++;
            }
            int dontTake = minCoinsMemoization(coins, amt, idx + 1, cache);
            cache[amt][idx] = Math.min(take, dontTake);
        }
        return cache[amt][idx];
    }
}
