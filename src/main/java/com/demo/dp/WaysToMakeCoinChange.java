package com.demo.dp;

public class WaysToMakeCoinChange {

    /**
     * For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}.
     * You need to figure out the total number of ways W,
     * in which you can make the change for Value V using coins of denominations D.
     * Return 0 if the change isn't possible.
     *
     * TC: O(mn)
     * SC: O(mn)
     */
    public static void main(String[] args) {
        // Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
        System.out.println(countWaysToMakeChange(new int[]{1, 2, 3}, 4));
    }

    public static int countWaysToMakeChange(int coins[], int value) {
        int[][] memo = new int[coins.length][value + 1];

        for (int coinIdx = 0; coinIdx < coins.length; coinIdx++) {
            for (int valueIdx = 0; valueIdx <= value; valueIdx++) {
                if (valueIdx == 0) { // Weight of coin = 0
                    memo[coinIdx][valueIdx] = 1;
                } else {
                    // Two possibilities: exclude the coin || include the coin
                    // Result = Prev column possibilities + same row remaining coin value possibility
                    memo[coinIdx][valueIdx] = get(coinIdx - 1, valueIdx, memo) +
                            get(coinIdx, valueIdx - coins[coinIdx], memo);
                }
            }
        }

        return memo[coins.length - 1][value];
    }

    private static int get(int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return memo[i][j];
    }
}
