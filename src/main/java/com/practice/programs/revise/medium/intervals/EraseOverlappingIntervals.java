package com.practice.programs.revise.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 * TC: O(n log n), AS: O(1)
 * Concepts:
 * INTERVAL
 * INTERVAL_SORT_ON_ENDING_TIME
 */
public class EraseOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1])
                .thenComparingInt(a -> a[0]));
        int removedIntCount = 0;
        int n = intervals.length;
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            if (isOverlapping(prev, curr)) {
                removedIntCount++;
            } else {
                prev = curr;
            }
        }
        return removedIntCount;
    }

    private boolean isOverlapping(int[] prev, int[] curr) {
        return curr[0] == prev[0] && curr[1] == prev[1] || curr[0] < prev[1];
    }
}
