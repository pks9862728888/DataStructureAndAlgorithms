package com.practice.programs.revise.easy.array.stockbuynsell;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * TC: O(n * 2 * 3), AS: O(n * 2 * 3) + O(n) - stack space
 * Concepts:
 * DP
 * MEMOIZATION
 * BOUNDED_ZERO_ONE_KNAPSACK
 * BUY_OR_SELL_STOCK
 */
public class StockBuyAndSell3 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] cache = new int[n][2][3];
        for (int[][] d1: cache) {
            for (int[] row: d1) {
                Arrays.fill(row, -1);
            }
        }
        return findProfit(prices, 0, n, 2, true, cache);
    }

    /**
     * At every position you can either sell only if you have already bought a stock
     * For buy & sell operation every time we will have 2 possibilities consider current idx or exclude
     */
    private int findProfit(int[] prices, int idx, int n, int txnCount, boolean shouldBuy, int[][][] cache) {
        if (idx == n || txnCount <= 0) {
            return 0;
        }
        if (cache[idx][shouldBuy ? 1 : 0][txnCount] == -1) {
            int maxProfit = 0;
            if (shouldBuy) {
                // buy
                maxProfit = Math.max(maxProfit, -prices[idx] + findProfit(prices, idx + 1, n, txnCount, false, cache));
                // dontBuy
                maxProfit = Math.max(maxProfit, findProfit(prices, idx + 1, n, txnCount, true, cache));
            } else {
                // sell
                maxProfit = Math.max(maxProfit, prices[idx] + findProfit(prices, idx + 1, n, txnCount - 1, true, cache));
                // dontSell
                maxProfit = Math.max(maxProfit, findProfit(prices, idx + 1, n, txnCount, false, cache));
            }
            cache[idx][shouldBuy ? 1 : 0][txnCount] = maxProfit;
        }
        return cache[idx][shouldBuy ? 1 : 0][txnCount];
    }
}
