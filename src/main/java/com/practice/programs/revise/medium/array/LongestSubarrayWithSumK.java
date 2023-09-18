package com.practice.programs.revise.medium.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Intuition:
 * If prefixSum - k is already present in hash, then sum(elements) after idx from hash = k
 */
class LongestSubarrayWithSumK {

    // 1, 2, 3, 1, 1, 1, 1, k = 3 -> 3 [1, 1, 1]

    /**
     * TC: O(2n), AS: O(1)
     * <a href="https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
     */
    public static int longestSubarrayWithSumKOnlyPositivesAndZeros(int []arr, long k) {
        int longestSubarrayWithSumK = 0;
        int left = 0;
        int right = 0;
        int n = arr.length;
        long sum = 0;
        while(right < n) {
            sum += arr[right];
            while (sum > k && left <= right) {
                sum -= arr[left++];
            }
            if (sum == k) {
                longestSubarrayWithSumK = Math.max(longestSubarrayWithSumK,
                        right - left + 1);
            }
            right++;
        }
        return longestSubarrayWithSumK;
    }

    // -1 0 1 1 -1 -1 0 -> ans = 6 [0 1 1 -1 -1 0]

    /**
     * TC: O(n), AS: O(n)
     * <a href="https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
     */
    public static int getLongestSubarrayHavingZerosAndNegatives(int []nums, int k) {
        int longestSubarrayWithSumK = 0;
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                longestSubarrayWithSumK = Math.max(longestSubarrayWithSumK, i + 1);
            } else {
                long rem = sum - k;
                if (prefixSumMap.containsKey(rem)) {
                    longestSubarrayWithSumK = Math.max(longestSubarrayWithSumK, i - prefixSumMap.get(rem));
                }
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return longestSubarrayWithSumK;
    }
}
