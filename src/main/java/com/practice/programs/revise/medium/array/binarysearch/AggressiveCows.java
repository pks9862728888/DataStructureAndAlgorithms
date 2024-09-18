package com.practice.programs.revise.medium.array.binarysearch;

import java.util.Arrays;

/**
 * TC: O(nlog n + n * log 10^9), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * https://www.geeksforgeeks.org/problems/aggressive-cows/1
 * Find maximum possible minimum distance
 * Concepts:
 * BINARY_SEARCH
 */
class AggressiveCows {

    // 1, 2, 3 -> ans = 2

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int st = 1;
        int end = stalls[stalls.length - 1];
        int minDistance = 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (canPlaceCows(stalls, mid, k)) {
                minDistance = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return minDistance;
    }

    private static boolean canPlaceCows(int[] stalls, int distance, int maxCows) {
        int prevStall = stalls[0];
        int cowsCount = 1;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prevStall >= distance) {
                prevStall = stalls[i];
                cowsCount++;
            }
            if (cowsCount >= maxCows) {
                return true;
            }
        }
        return false;
    }
}
