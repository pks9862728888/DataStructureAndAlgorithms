package com.practice.programs.revise.easy.array.stockbuynsell;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * TC: O(n), AS: O(1)
 * Pattern1:
 * Given stock prices of various days,
 * find max profit which can be earned if you are allowed to perform only 1 buy & sell transaction.
 * You can't buy & sell on same day
 * Concept:
 * ARRAY
 * BUY_OR_SELL_STOCK
 */
public class StockBuyAndSell1 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int mp = 0;
        int minSoFar = prices[0];
        for (int p: prices) {
            if (p < minSoFar) {
                minSoFar = p;
            } else {
                mp = Math.max(mp, p - minSoFar);
            }
        }
        return mp;
    }
}
