package com.practice.programs.revise.medium.array.twopointer;

/**
 * Find the duplicate number in an array: no are from 1 - n, and one is duplicate
 * TWO_POINTER
 * FAST_AND_SLOW_POINTER
 */
public class FindDuplicateNo {

  /**
   * Floyd's Tortoise and Hare (Cycle Detection) approach
   * TC: O(n), AS: O(1)
   * No in place modification
   */
  public static int findDuplicate1(int[] nums) {
    int fast = nums[0];
    int slow = nums[0];

    // go upto the point where fast and slow intersects
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    // reset slow to start and move one step at a time
    // when they meet again its the intersection point
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  /**
   * Index marker approach,
   * TC: O(n), AS: O(1)
   * But it modifies original array
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
