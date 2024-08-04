package com.practice.programs.revise.medium.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * Scenarios:
 * New interval can be inserted before previous interval
 * New interval can be merged with previous interval
 * New interval can be inserted after all intervals
 * TC: O(n)
 * AS: O(n)
 * Concept:
 * INTERVAL
 */
public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        boolean newIntervalProcessed = false;
        for (int[] currInterval: intervals) {
            //   if newIntervalProcessed = true,
            if (newIntervalProcessed) {
                //       check if current interval can be part of previousInterval
                //            if yes, merge previous and current interval
                //            else, insert interval
                int n = resList.size();
                if (n > 0 && canMerge(resList.get(n - 1), currInterval)) {
                    int[] mergedInterval = mergeInterval(resList.get(n - 1), currInterval);
                    resList.set(n - 1, mergedInterval);
                } else {
                    resList.add(currInterval);
                }
            } else if (canMerge(currInterval, newInterval)) {
                //   else check if newInterval is part of currInterval
                //      if yes, set newIntervalProcessed = true && merge current interval with previous interval (if any)
                newIntervalProcessed = true;
                resList.add( mergeInterval(currInterval, newInterval));
            } else if (canInsertBefore(currInterval, newInterval)) {
                // If new interval can be inserted before currInterval
                newIntervalProcessed = true;
                resList.add(newInterval);
                resList.add(currInterval);
            } else {
                // no merging is possible, so append
                resList.add(currInterval);
            }
        }
        if (!newIntervalProcessed) {
            resList.add(newInterval);
        }
        // convert array list to result array and return
        return resList.toArray(new int[0][0]);
    }

    private int[] mergeInterval(int[] currInterval, int[] newInterval) {
        return new int[]{Math.min(currInterval[0], newInterval[0]), Math.max(currInterval[1], newInterval[1])};
    }

    private boolean canMerge(int[] currInterval, int[] newInterval) {
        return newInterval[0] <= currInterval[1] && newInterval[1] >= currInterval[0];
    }

    private boolean canInsertBefore(int[] currInterval, int[] newInterval) {
        return newInterval[1] < currInterval[0];
    }
}
