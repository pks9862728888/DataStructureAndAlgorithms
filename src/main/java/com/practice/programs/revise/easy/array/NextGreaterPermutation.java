package com.practice.programs.revise.easy.array;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * If no next permutations are possible, return the least possible permutation
 * TC: O(n ^ 2), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/next-greater-permutation_6929564?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 * Concepts:
 * ARRAY
 * NEXT_GREATER_PERMUTATION
 * 4152 = 4215
 */
class NextGreaterPermutation {


  public void nextPermutation(int[] nums) {
    // find pivot idx where curr element is less than next element
    int pivotIdx = nums.length - 2;
    while (pivotIdx >= 0 && nums[pivotIdx] >= nums[pivotIdx + 1]) pivotIdx--;

    // if no such idx exists sort in ascending order
    if (pivotIdx == -1) {
      reverse(nums, 0, nums.length - 1);
    } else {
      // if such idx exists, swap the element with next smallest element towards right which is > curr
      int nextSmallerIdx = nums.length - 1;
      while (nums[nextSmallerIdx] <= nums[pivotIdx]) nextSmallerIdx--;
      swap(nums, pivotIdx, nextSmallerIdx);
      // reverse right most portion (ascending order - it gives next higher permutation)
      reverse(nums, pivotIdx + 1, nums.length - 1);
    }
  }

  private void reverse(int[] n, int li, int ri) {
    while (li < ri) {
      swap(n, li, ri);
      li++;
      ri--;
    }
  }

  private void swap(int[] n, int i1, int i2) {
    int t = n[i1];
    n[i1] = n[i2];
    n[i2] = t;
  }
}
