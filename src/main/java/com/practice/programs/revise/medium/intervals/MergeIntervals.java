package com.practice.programs.revise.medium.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * TC: O(n log n)
 * AS: O(n)
 * Concept:
 * INTERVAL
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] currInterval: intervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(currInterval);
            } else {
                int[] prev = mergedIntervals.get(mergedIntervals.size() - 1);
                if (canMerge(prev, currInterval)) {
                    prev[0] = Math.min(prev[0], currInterval[0]);
                    prev[1] = Math.max(prev[1], currInterval[1]);
                } else {
                    mergedIntervals.add(currInterval);
                }
            }
        }
        return mergedIntervals.toArray(new int[0][0]);
    }

    private boolean canMerge(int[] prev, int[] curr) {
        return curr[0] <= prev[1];
    }
}
