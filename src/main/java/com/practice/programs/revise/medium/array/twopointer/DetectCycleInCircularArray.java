package com.practice.programs.revise.medium.array.twopointer;

/**
 * TC: O(n) SC: O(1)
 * e.g:
 * [1,3,-2,-4,1] - true
 * [2,1,-1,-2] - false
 */
public class DetectCycleInCircularArray {

  /**
   * starting from any idx, cycle should not exist
   * direction should be consistent (all +ve, if positive and vice versa)
   * no self loop should exist
   * more than 1 element should be there in cycle
   */
  public static boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int slow = i;
      int fast = i;
      boolean isForward = nums[i] > 0;

      while (true) {
        // move slow by 1
        int next = next(slow, nums[slow], n);
        if (isNotCycle(nums[slow], isForward, next, slow)) {
          break;
        }
        slow = next;

        // move fast by 1
        next = next(fast, nums[fast], n);
        if (isNotCycle(nums[fast], isForward, next, fast)) {
          break;
        }
        fast = next;

        // move fast by 1 again
        next = next(fast, nums[fast], n);
        if (isNotCycle(nums[fast], isForward, next, fast)) {
          break;
        }
        fast = next;

        if (slow == fast) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean isNotCycle(int number, boolean isForward, int next, int curr) {
    // if direction changes or self loop exists then not a cycle
    return number > 0 != isForward || next == curr;
  }

  private static int next(int currIdx, int delta, int n) {
    return ((currIdx + delta) % n + n) % n;
  }
}
