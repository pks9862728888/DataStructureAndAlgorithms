package com.practice.programs.revise.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * TC: O(n log n), AS: O(n)
 * INTERVAL
 * INTERVAL_SORT_ON_STARTING_TIME
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        sortAscendingOrderByStartTime(intervals);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int minRooms = 0;
        for (int[] interval: intervals) {
            while (!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }
            minHeap.add(interval);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    private static void sortAscendingOrderByStartTime(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));
    }
}
