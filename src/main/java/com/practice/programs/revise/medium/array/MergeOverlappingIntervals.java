package com.practice.programs.revise.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TC: O(nlogn + n), AS: O(n)
 */
public class MergeOverlappingIntervals {

    public int[][] mergeIntervals(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0][];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));  // Intervals may not be in sorted order
        List<int[]> res = new ArrayList<>();
        for (int[] interval: arr) {
            if (isOverlapping(res, interval)) {
                mergeLastInterval(res, interval);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[0][]);
    }

    private void mergeLastInterval(List<int[]> res, int[] interval) {
        int[] prevInterval = res.get(res.size() - 1);
        prevInterval[1] = Math.max(prevInterval[1], interval[1]);
    }

    private boolean isOverlapping(List<int[]> res, int[] interval) {
        if (res.isEmpty()) {
            return false;
        }
        return res.get(res.size() - 1)[1] >= interval[0];
    }
}
