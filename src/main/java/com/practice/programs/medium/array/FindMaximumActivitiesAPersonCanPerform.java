package com.practice.programs.medium.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TC: O(n log n), AS: O(n)
 */
class FindMaximumActivitiesAPersonCanPerform {

    // Start and end time of activity is provided
    // Sort based on end time
    // Pick up activity if next activities start time >= prev activities end time

    static int activitySelection(int n, int starting[], int ending[]) {
        List<Pair> activityPair = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activityPair.add(new Pair(starting[i], ending[i]));
        }
        Collections.sort(activityPair);
        Pair prev = new Pair(-1, -1);
        int activityCount = 0;
        for (Pair activity: activityPair) {
            if (activity.start >= prev.end) {
                activityCount++;
                prev = activity;
            }
        }
        return activityCount;
    }

    private static class Pair implements Comparable<Pair> {
        int start;
        int end;
        Pair(int st, int end) {
            start = st;
            this.end = end;
        }
        @Override
        public int compareTo(Pair b) {
            return Integer.compare(end, b.end);
        }
    }
}
