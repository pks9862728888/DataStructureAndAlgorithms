package com.practice.programs.revise.medium.intervals;

import java.util.Arrays;

/**
 * https://takeuforward.org/interviews/blind-75-leetcode-problems-detailed-video-solutions
 * TC: O(n log n), AS: O(1)
 * Concepts:
 * INTERVAL
 * INTERVAL_SORT_ON_ENDING_TIME
 */
public class MeetingRooms1 {

    public boolean canAttendMeetings(int[][] intervals) {
        sortByEndingTime(intervals);
        int n = intervals.length;
        boolean canAttend = true;
        for (int i = 1; i < n; i++) {
            int[] prev = intervals[i - 1];
            int[] curr = intervals[i];
            if (!canAttend(prev, curr)) {
                canAttend = false;
                break;
            }
        }
        return canAttend;
    }

    private static void sortByEndingTime(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int res = a[1] - b[1];
            if (res == 0) {
                res = a[0] - b[0];
            }
            return res;
        });
    }

    private boolean canAttend(int[] prev, int[] curr) {
        return curr[0] >= prev[1];
    }
}
