package com.demo.dp;

import java.util.HashMap;

public class BytelandianCoinExchange {

    /**
     * Byteland has a very strange monetary system.
     * Each Bytelandian gold coin has an integer number written on it.
     * A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4.
     * But these numbers are all rounded down (the banks have to make a profit).
     * You can also sell Bytelandian coins for American dollars.
     * The exchange rate is 1:1. But you can not buy Bytelandian coins.
     * You have one gold coin. What is the maximum amount of American dollars you can get for it?
     *
     * You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
     */
    public static void main(String[] args) {
        System.out.println(bytelandian(12, new HashMap<>()));
    }

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        long k = Math.min(10000, n);
        for (long i = 0; i <= k; i++) {
            getMaxProfit(i, memo);
        }
        return memo.getOrDefault(n, getMaxProfit(n, memo));
    }

    private static long getMaxProfit(long n, HashMap<Long, Long> memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            long p1 = getMaxProfit(n / 2, memo);
            long p3 = getMaxProfit(n / 3, memo);
            long p4 = getMaxProfit(n / 4, memo);
            long profit = Math.max(n, (p1 + p3 + p4));
            if (n < 10000) {
                memo.put(n, profit);
            }
            return profit;
        }
    }

}