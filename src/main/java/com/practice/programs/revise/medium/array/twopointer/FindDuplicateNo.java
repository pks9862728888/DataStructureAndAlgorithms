package com.practice.programs.revise.medium.array.twopointer;

/**
 * Find the duplicate number in an array: no are from 1 - n, and one is duplicate
 * TWO_POINTER
 */
public class FindDuplicateNo {

  /**
   * Index marker approach,
   * TC: O(n), AS: O(1)
   */
  public static int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int idx = Math.abs(nums[i]) - 1; // find correct idx for no
      if (nums[idx] < 0) {
        return Math.abs(nums[i]); // duplicate found
      } else {
        nums[idx] = -nums[idx]; // mark position as visited by making value -ve
      }
    }

    return -1;
  }
}
