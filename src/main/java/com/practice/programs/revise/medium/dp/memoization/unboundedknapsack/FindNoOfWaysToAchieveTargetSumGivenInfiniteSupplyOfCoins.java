package com.practice.programs.revise.medium.dp.memoization.unboundedknapsack;

import java.util.Objects;

public class FindNoOfWaysToAchieveTargetSumGivenInfiniteSupplyOfCoins {

    /**
     * TC: O (amount * n), AS: O(amount * n)
     * Sample input: 1 2 3
     * ans = 4 {1,1,1,1}, {1,1,2}, {2,2}, and {1,3}
     * pattern: UNBOUNDED_ZERO_ONE_KNAPSACK
     */
    public static long coinChange(int amount, int n, int []coins) {
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
            long pickPossibilities = possibleCoinChanges(amount - coins[idx], n, coins, idx, cache);
            long dontPickPossibilities = possibleCoinChanges(amount, n, coins, idx + 1, cache);
            cache[amount][idx] = pickPossibilities + dontPickPossibilities;
        }
        return cache[amount][idx];
    }

}
