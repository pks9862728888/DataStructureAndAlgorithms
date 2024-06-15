package com.practice.programs.revise.medium.dp.memoization.unboundedknapsack;

import java.util.Arrays;

public class FindMaxProfitObtainedByCuttingRod {

    /**
     * TC: O(rodLength * peices.length), same AS
     * concept:
     * MEMOIZATION
     * UNBOUNDED_ZERO_ONE_KNAPSACK
     * UNBOUNDED_ZERO_ONE_KNAPSACK_SHOWING_OUTCOME_NOT_POSSIBLE
     * Input:
     * 5
     * 1 9 3 3 3
     * ans = 19
     * Rod can be cut up in lengths of 1 + 2 + 2 which corresponds to the price of 1 + 9 + 9 =19
     */
    static int rodCutting(int rodLength, int price[]) {
        int[][] cache = new int[rodLength + 1][price.length + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return findMaxPrice(price, 0, rodLength, cache);
    }

    static int findMaxPrice(int[] price, int idx, int rodLen, int[][] cache) {
        if (rodLen == 0) { // possible solution
            return 0;
        } else if (rodLen < 0 || idx == price.length) { // Not possible solution
            return Integer.MIN_VALUE;
        }
        if (cache[rodLen][idx] == -1) {
            int priceCut = findMaxPrice(price, idx, rodLen - (idx + 1), cache) + price[idx];
            int priceDontCut = findMaxPrice(price, idx + 1, rodLen, cache);
            cache[rodLen][idx] = Math.max(priceCut, priceDontCut);
        }
        return cache[rodLen][idx];
    }

}
