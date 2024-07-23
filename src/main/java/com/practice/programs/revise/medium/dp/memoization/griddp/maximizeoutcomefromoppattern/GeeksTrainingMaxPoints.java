package com.practice.programs.revise.medium.dp.memoization.griddp.maximizeoutcomefromoppattern;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training
 * TC: 3 ^ n
 * AS: O(4 * n)
 * Each day you can pick up an idx, but in subsequent day you can't pick up same index
 * find max points
 * Concept:
 * DP
 * TABULATION
 * MAXIMIZE_OUTCOME_FROM_ALL_OPERATIONS
 */
public class GeeksTrainingMaxPoints {

    public int maximumPoints(int points[][],int n){
        int[][] cache = new int[n][4];
        for (int[] row: cache) Arrays.fill(row, -1);
        return maximize(points, n, 0, -1, cache);
    }

    private int maximize(int[][] points, int n, int day, int prevActIdx, int[][] cache) {
        if (day >= n) {
            return 0;
        }
        // get which activity yields maximum
        if (cache[day][prevActIdx + 1] == -1) {
            int point = 0;
            for (int i = 0; i < 3; i++) {
                if (i != prevActIdx) {
                    point = Math.max(point, maximize(points, n, day + 1, i, cache) + points[day][i]);
                }
            }
            cache[day][prevActIdx + 1] = point;
        }
        return cache[day][prevActIdx + 1];
    }
}
