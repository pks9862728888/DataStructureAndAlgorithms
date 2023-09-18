package com.practice.programs.revise.medium.array;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/best-time-to-buy-and-sell-stock_6194560?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class StockBuyAndSellToMakeMaxProfit1 {

    // 7 1 5 4 3 6 -> 6 - 1 = 5
    // 5 4 3 2 1 -> 0
    // You can buy only 1 stock in total

    /**
     * TC: O(n), AS: O(1)
     */
    private static int bruteForceApproach2(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }

        return maxProfit;
    }

    /**
     * TC: O(2n), AS: O(2n)
     */
    private static int bruteForceApproach1(int[] prices) {
        int[] prefixMin = new int[prices.length];
        int[] suffixMax = new int[prices.length];
        int pm = Integer.MAX_VALUE;
        int sm = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            pm = Math.min(pm, prices[i]);
            sm = Math.max(sm, prices[prices.length - i - 1]);
            prefixMin[i] = pm;
            suffixMax[prices.length - i - 1] = sm;
        }

        // Find max profit
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, suffixMax[i] - prefixMin[i]);
        }
        return maxProfit;
    }

}
