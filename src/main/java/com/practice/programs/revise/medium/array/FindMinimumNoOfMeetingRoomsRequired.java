package com.practice.programs.revise.medium.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * TC: AS: O(n log n) O(1)
 * Intuition:
 * When before current meeting starts,
 * if any previous allocated room is completed, then no new room is required
 * else new room is required
 */
public class FindMinimumNoOfMeetingRoomsRequired {

    public int findNumRooms(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.add(intervals[0][1]);
        int noOfRooms = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] currMeeting = intervals[i];
            if (currMeeting[0] < rooms.peek()) {
                noOfRooms++;
            } else {
                rooms.poll();
            }
            rooms.add(currMeeting[1]);
        }
        return noOfRooms;
    }

}
