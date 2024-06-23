package com.practice.programs.revise.medium.dp.memoization.unboundedknapsack;

import java.util.Objects;

public class FindNoOfWaysToAchieveTargetSumGivenInfiniteSupplyOfCoins {

    private static final int[] coins = {1, 5, 10, 25};
    private static final long MOD = 1000000007;

    /**
     * TC: O (amount * n), AS: O(amount * n)
     * Sample input: 1 2 3
     * ans = 4 {1,1,1,1}, {1,1,2}, {2,2}, and {1,3}
     * pattern:
     * MEMOIZATION
     * TABULATION
     * UNBOUNDED_ZERO_ONE_KNAPSACK
     */
    public static long coinChangeMemoized(int amount, int n, int[] coins) {
        Long[][] cache = new Long[amount + 1][n + 1];
        return possibleCoinChanges(amount, n, coins, 0, cache);
    }

    private static long possibleCoinChanges(int amount, int n, int[] coins, int idx, Long[][] cache) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || idx == n) {
            return 0;
        }
        if (Objects.isNull(cache[amount][idx])) {
            long dontPickPossibilities = possibleCoinChanges(amount, n, coins, idx + 1, cache);
            long pickPossibilities = possibleCoinChanges(amount - coins[idx], n, coins, idx, cache);
            cache[amount][idx] = (pickPossibilities + dontPickPossibilities) % MOD;
        }
        return cache[amount][idx];
    }

    private static int tabulation(int n) {
        if (n == 0) return 1;
        long[][] cache = new long[n + 1][coins.length];
        // Pre-calculate value for base case
        for (int target = 0; target <= n; target++) {
            cache[target][0] = target % coins[0] == 0 ? 1 : 0;
        }
        for (int centIdx = 1; centIdx < coins.length; centIdx++) {
            for (int target = 0; target <= n; target++) {
                // If we don't take a coin, then no of ways will be ways of previous coin
                long notTake = cache[target][centIdx - 1];
                // If we take, then no of possibilities will be equal to no of possibilities of remaining for current coin
                long take = coins[centIdx] <= target ? cache[target - coins[centIdx]][centIdx] : 0;
                cache[target][centIdx] = (take + notTake) % MOD;
            }
        }
        return (int) cache[n][coins.length - 1];
    }

}
