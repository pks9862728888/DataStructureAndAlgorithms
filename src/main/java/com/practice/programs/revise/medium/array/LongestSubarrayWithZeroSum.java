package com.practice.programs.revise.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                maxLen = i + 1;
            } else if (prefixSumMap.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - prefixSumMap.get(prefixSum));
            }
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    /**
     * Variant where it's asked to find the sub array where zero sum exists,
     * if not possible return -1,
     * if multiple are possible return the first group
     * TC: O(n), AS: O(n)
     * Input: 2 3 1 -4 6
     * Output: 3 1 -4
     * Concepts:
     * PREFIX_SUM
     * ZERO_SUM_SUBARRAY
     */
    static List<Integer> dailyTransactions(int n, int arr[]) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // to handle edge case where all elements are 0
        int st = -1;
        int end = -1;
        int maxLength = 0;
        int prefixSum = 0;
        for (int currIdx = 0; currIdx < n; currIdx++) {
            prefixSum += arr[currIdx];
            // If map contains key, then see if curr length is max, if yes calculate start and end
            if (prefixSumMap.containsKey(prefixSum)) {
                int stIdx = prefixSumMap.get(prefixSum);
                int len = currIdx - stIdx;
                if (len > maxLength) {
                    maxLength = len;
                    st = stIdx + 1;
                    end = currIdx;
                }
            }
            // Add prefixSum to map if not already exists
            prefixSumMap.putIfAbsent(prefixSum, currIdx);
        }
        return findMaxLengthSubArray(arr, maxLength, st, end);
    }

    private static List<Integer> findMaxLengthSubArray(int[] arr, int maxLength, int st, int end) {
        List<Integer> res = new ArrayList<>();
        if (maxLength != 0) {
            for (int i = st; i <= end; i++) {
                res.add(arr[i]);
            }
        } else {
            res.add(-1);
        }
        return res;
    }
}
