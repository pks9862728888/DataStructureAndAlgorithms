package com.practice.programs.revise.easy.array.stockbuynsell;

/**
 * TC: O(n), AS: O(1)
 * Concept:
 * ARRAY
 * BUY_OR_SELL_STOCK
 */
class StockBuyAndSell2 {

    private int maxProfitIfYouAreAllowedToHoldOneStockAtATime(int[] arr) {
        // Loop through array
        // Sell stock if todays stock price is greater than previous days stock price
        // Scenarios for two days:
        // price stays same each day -> no action
        // price keeps increasing -> keep on buying today and selling the next day and then buy again
        // price decreases -> no action
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                res += arr[i] - arr[i - 1];
            }
        }
        return res;
    }
}
