package com.practice.programs.revise.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/longest-subarray-with-zero-sum_6783450?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class LongestSubarrayWithZeroSum {

    /**
     * TC: O(n), AS: O(n)
     * Intuition:
     * If current sum = 0, then curr idx is the length of longest subArray
     * If current prefix sum already occurred, then sum(ele in between) = 0
     */
    public static int getLongestZeroSumSubarrayLength(int []arr){
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int longestSubArrayLength = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                longestSubArrayLength = i + 1;
            } else if (prefixSumMap.containsKey(prefixSum)) {
                longestSubArrayLength = Math.max(
                        longestSubArrayLength, i - prefixSumMap.get(prefixSum));
            }
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return longestSubArrayLength;
    }
}
