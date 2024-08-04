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
        List<Integer[]> resList = new ArrayList<>();
        boolean newIntervalProcessed = false;
        for (int[] currInterval: intervals) {
            //   if newIntervalProcessed = true,
            if (newIntervalProcessed) {
                //       check if current interval can be part of previousInterval
                //            if yes, merge previous and current interval
                //            else, insert interval
                int n = resList.size();
                if (n > 0 && canMerge(resList.get(n - 1), currInterval)) {
                    Integer[] mergedInterval = mergeInterval(resList.get(n - 1), currInterval);
                    resList.set(n - 1, mergedInterval);
                } else {
                    resList.add(new Integer[]{currInterval[0], currInterval[1]});
                }
            } else if (canMerge(currInterval, newInterval)) {
                //   else check if newInterval is part of currInterval
                //      if yes, set newIntervalProcessed = true && merge current interval with previous interval (if any)
                newIntervalProcessed = true;
                Integer[] mergedInterval = mergeInterval(currInterval, newInterval);
                resList.add(mergedInterval);
            } else if (canInsertBefore(currInterval, newInterval)) {
                // If new interval can be inserted before currInterval
                newIntervalProcessed = true;
                resList.add(new Integer[]{newInterval[0], newInterval[1]});
                resList.add(new Integer[]{currInterval[0], currInterval[1]});
            } else {
                // no merging is possible, so append
                resList.add(new Integer[]{currInterval[0], currInterval[1]});
            }
        }
        if (!newIntervalProcessed) {
            resList.add(new Integer[]{newInterval[0], newInterval[1]});
        }
        // convert array list to result array and return
        return convertToArray(resList);
    }

    private int[][] convertToArray(List<Integer[]> resList) {
        int n = resList.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            Integer[] arr = resList.get(i);
            res[i][0] = arr[0];
            res[i][1] = arr[1];
        }
        return res;
    }

    private Integer[] mergeInterval(int[] currInterval, int[] newInterval) {
        return new Integer[]{Math.min(currInterval[0], newInterval[0]), Math.max(currInterval[1], newInterval[1])};
    }

    private Integer[] mergeInterval(Integer[] currInterval, int[] newInterval) {
        return new Integer[]{Math.min(currInterval[0], newInterval[0]), Math.max(currInterval[1], newInterval[1])};
    }

    private boolean canMerge(int[] currInterval, int[] newInterval) {
        return newInterval[0] <= currInterval[1] && newInterval[1] >= currInterval[0];
    }

    private boolean canMerge(Integer[] currInterval, int[] newInterval) {
        return newInterval[0] <= currInterval[1] && newInterval[1] >= currInterval[0];
    }

    private boolean canInsertBefore(int[] currInterval, int[] newInterval) {
        return newInterval[1] < currInterval[0];
    }
}
