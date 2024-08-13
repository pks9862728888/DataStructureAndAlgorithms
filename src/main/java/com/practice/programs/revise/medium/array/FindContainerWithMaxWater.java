package com.practice.programs.revise.medium.array;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * TC: O(n), AS: O(1)
 * Concept:
 * TWO_POINTER
 */
public class FindContainerWithMaxWater {

    // 1 8 6 2 5 4 8 3 7 -> 49 (left most 8 & right most 7 is the container
    // Assume width of bars is negligible and n >= 2

    public int maxArea(int[] h) {
        int low = 0;
        int high = h.length - 1;
        int mxArea = 0;
        while (low < high) {
            // Calculate max water which can be held
            mxArea = Math.max(mxArea, Math.min(h[low], h[high]) * (high - low));
            // Whichever line is low in height, ignore that (because we want max water)
            if (h[low] <= h[high]) {
                low++;
            } else {
                high--;
            }
        }
        return mxArea;
    }
}
