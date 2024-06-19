package com.practice.programs.revise.medium.array.slidingwindownprefixsum;

import java.util.List;

public class PickItemsFromRightNLeftToGetMaxSum {

    /**
     * Pick k items from right and left to get max sum
     * TC: O(n), AS: O(1)
     * Concept:
     * SLIDING_WINDOW
     * PREFIX_SUM
     * Input:
     * 2 3 1 2 5 1, n = 6, k = 4, res = 11
     * 2 3     5 1
     */
    static long donuts(int n, int k, List<Integer> items) {
        // Find sum
        long sum = sum(items, 0, n - 1); // 14

        // Base case, if n == k, return sum of array
        if (n == k) {
            return sum;
        }

        // We will use sliding window along with prefix sum technique
        // Initialize window width, start = 0, windowEnd = n - k - 1
        // 2 3 1 2 5 1, n = 6, k = 4
        int start = 0;
        int end = n - k - 1; // 1

        // Find sum of window, windowSum = (start, windowEnd)
        long windowSum = sum(items, start, end); // 5

        // Initialize maxSum to store result
        long maxSum = sum - windowSum; // 14 - 5 = 9

        // Iterate from windowEnd till end of list
        while (++end < n) { // 5, st = 2
            // For each iteration, windowSum = windowSum + items[windowEnd] - items[start]
            windowSum = windowSum + items.get(end) - items.get(start++); // 3 + 1 - 1 = 3
            // Find sum excluding windowSum = sum - windowSum
            long sumWithoutWindowSum = sum - windowSum;  // 14 - 3 = 11
            // Update maxSum if max
            maxSum = Math.max(maxSum, sumWithoutWindowSum); // 11
        }

        // return result
        return maxSum; // 11
    }

    private static long sum(List<Integer> items, int st, int end) {
        long res = 0;
        for (int i = st; i <= end; i++) {
            res += items.get(i);
        }
        return res;
    }
}
