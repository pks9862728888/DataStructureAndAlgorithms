package com.practice.programs.revise.medium.array.slidingwindow;

import java.util.Arrays;

/**
 * TC: O(n log n) + O(n) => O(n log n)
 * SC: O(1)
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 */
public class FreqOfMostFrequentElement {

  public static int maxFrequency(int[] nums, int k) {
    if (nums.length == 0) return 0;
    // create a var to store max freq, and a var to track incements made (inc)
    int maxFreq = 1;
    long inc = 0;
    // sort the array in ascending order
    Arrays.sort(nums);
    // fix left pointer = 0, right pointer = 0, n = length of array
    int n = nums.length;
    int lp = 0;
    for (int rp = 1; rp < n; rp++) {
      // figure out the increments required by baselining with previous element
      inc += (long) (nums[rp] - nums[rp - 1]) * (rp - lp);
      while (inc > k) {
        inc -= (nums[rp] - nums[lp]);
        lp++;
      }
      maxFreq = Math.max(maxFreq, (rp - lp + 1));
    }
    return maxFreq;
  }

}
