package com.practice.programs.revise.medium.dp.memoization.zeroonesubsequence;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    /**
     * TC: O(n * n), AS: O(n * n) + O(n)
     * Input: 5 4 1 6 2 2 5
     * Output: 3 {1,2,5}
     * Concept:
     * MEMOIZATION
     * BOUNDED_ZERO_ONE_SUBSEQ_PATTERN_TRACKING_PREV
     */
    private static int longestIncreasingSubsequence(List<Integer> nums){
        int n = nums.size();
        int[][] cache = new int[n + 1][n];
        for (int[] row: cache) Arrays.fill(row, -1);
        return findLongest(nums, -1, 0, cache);
    }

    private static int findLongest(List<Integer> nums, int prevIdx, int currIdx, int[][] cache) {
        if (currIdx == nums.size()) {
            return 0;
        }
        if (cache[prevIdx + 1][currIdx] == -1) {
            int dontTakeLen = findLongest(nums, prevIdx, currIdx + 1, cache);
            int takeLen = (prevIdx == -1 || nums.get(currIdx) > nums.get(prevIdx)) ?
                    1 + findLongest(nums, currIdx, currIdx + 1, cache) : 0;
            cache[prevIdx + 1][currIdx] = Math.max(dontTakeLen, takeLen);
        }
        return cache[prevIdx + 1][currIdx];
    }
}
