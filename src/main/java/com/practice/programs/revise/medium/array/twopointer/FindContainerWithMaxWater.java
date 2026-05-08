package com.practice.programs.revise.medium.array.twopointer;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * TC: O(n), AS: O(1)
 * Concept:
 * TWO_POINTER
 */
public class FindContainerWithMaxWater {

    // 1 8 6 2 5 4 8 3 7 -> 49 (left most 8 & right most 7 is the container
    // Assume width of bars is negligible and n >= 2

    public int maxArea(ArrayList<Integer> heights) {
      int left = 0;
      int right = heights.size() - 1;
      int maxWater = 0;
      while (left < right) {
        int lh = heights.get(left);
        int rh = heights.get(right);
        int water = Math.min(lh, rh) * Math.abs(right - left);
        maxWater = Math.max(maxWater, water);

        if (lh < rh) {
          left++;
        } else if (rh < lh) {
          right--;
        } else {
          left++;
          right--;
        }
      }
      return maxWater;
    }
}
