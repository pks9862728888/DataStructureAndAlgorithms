package com.practice.programs.revise.easy.array;

import java.util.Arrays;

/**
 * If no next permutations are possible, return the least possible permutation
 * TC: O(n log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/next-greater-permutation_6929564?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
class NextGreaterPermutation {


    static int[] nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = findNextPermutationIdx(nums, i);
            if (idx != -1) {
                swap(nums, i, idx);
                Arrays.sort(nums, i + 1, nums.length);
                return nums;
            }
        }
        // Next permutation not possible, so return sorted array
        Arrays.sort(nums);
        return nums;
    }

    private static int findNextPermutationIdx(int[] nums, int minEleIdx) {
        int nextGreaterEleIdx = -1;
        for (int i = minEleIdx + 1; i < nums.length; i++) {
            if (nums[i] > nums[minEleIdx] && (nextGreaterEleIdx == -1 || nums[i] < nums[nextGreaterEleIdx])) {
                nextGreaterEleIdx = i;
            }
        }
        return nextGreaterEleIdx;
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int t = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = t;
    }
}
