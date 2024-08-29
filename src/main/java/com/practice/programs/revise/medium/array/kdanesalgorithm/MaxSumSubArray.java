package com.practice.programs.revise.medium.array.kdanesalgorithm;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * TC: O(n), AS: O(1)
 * Concepts:
 * ARRAY
 * KDANES_ALGORITHM
 */
public class MaxSumSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int largestSum = nums[0];
        int currSum = 0;
        int numsLen = nums.length;
        for (int i = 0; i < numsLen; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            largestSum = Math.max(largestSum, currSum);
        }
        return largestSum;
    }
}
