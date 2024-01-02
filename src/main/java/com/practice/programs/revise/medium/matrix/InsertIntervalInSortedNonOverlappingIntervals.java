package com.practice.programs.revise.medium.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(n), AS: O(n)
 * Insert new interval such that new intervals stays sorted non-overlapping
 */
public class InsertIntervalInSortedNonOverlappingIntervals {

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        boolean isNewIntervalProcessed = false;
        for (int[] currInterval: existingIntervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(copyInterval(currInterval));
            } else {
                merge(mergedIntervals, currInterval);
            }
            if (!isNewIntervalProcessed) {
                isNewIntervalProcessed = mergeOrInsertNewInterval(mergedIntervals, newInterval);
            }
        }
        if (!isNewIntervalProcessed) {
            mergedIntervals.add(newInterval);
        }
        return mergedIntervals.toArray(new int[][] {});
    }

    private static void merge(List<int[]> mergedIntervals, int[] currInterval) {
        int[] prevInterval = getPrevInterval(mergedIntervals);
        if (currInterval[0] <= prevInterval[1]) {
            // merge
            prevInterval[0] = Math.min(currInterval[0], prevInterval[0]);
            prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
        } else {
            mergedIntervals.add(copyInterval(currInterval));
        }
    }

    /**
     * Cases:
     * - new interval is before prevIntervalStart & ending is before prevInterval end - no overlap
     * - new interval is before prevIntervalStart but ending is within or after prevInterval end
     * - new interval is after prevIntervalEnd so no overlap with prev interval
     */
    private static boolean mergeOrInsertNewInterval(List<int[]> mergedIntervals, int[] newInterval) {
        boolean isNewIntervalProcessed = false;
        int[] prevInterval = getPrevInterval(mergedIntervals);
        if (newInterval[0] < prevInterval[0] && newInterval[1] < prevInterval[1]) {
            // No overlap, insert before
            mergedIntervals.add(mergedIntervals.size() - 1, copyInterval(newInterval));
            isNewIntervalProcessed = true;
        } else if (newInterval[0] <= prevInterval[1]) {
            // Overlap, full merge
            prevInterval[0] = Math.min(prevInterval[0], newInterval[0]);
            prevInterval[1] = Math.max(prevInterval[1], newInterval[1]);
            isNewIntervalProcessed = true;
        }
        return isNewIntervalProcessed;
    }

    private static int[] copyInterval(int[] interval) {
        return new int[] {interval[0], interval[1]};
    }

    private static int[] getPrevInterval(List<int[]> interval) {
        return interval.get(interval.size() - 1);
    }
}
