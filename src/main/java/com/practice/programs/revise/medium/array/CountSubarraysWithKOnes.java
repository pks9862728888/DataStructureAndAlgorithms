package com.practice.programs.revise.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.codingninjas.com/studio/problems/count-substrings-with-k-ones_3128698?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class CountSubarraysWithKOnes {

    // 1, 0, 1, k = 1 -> ans = 4 -> [1], [1, 0], [0, 1], [1]

    public static int subarrayWithSum(int []arr, int k) {
//         return betterApproach(arr, k);
        return optimalWithHashing(arr, k);
    }

    /**
     * TC: O(n), AS: O(n)
     */
    private static int optimalWithHashing(int[] arr, int k) {
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        int prefixSum = 0;
        int maxSubarrayCountWithSumK = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == k) {
                maxSubarrayCountWithSumK++;
            }
            // Though prefix sum = k, then also add maxSubArrayCount having 0 sum
            // else answer comes less
            // TODO: Need to figure out intuition behind this
            int rem = prefixSum - k;
            if (prefixSumCountMap.containsKey(rem)) {
                maxSubarrayCountWithSumK += prefixSumCountMap.get(rem);
            }
            prefixSumCountMap.put(prefixSum,
                    prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
        }
        return maxSubarrayCountWithSumK;
    }

    private static int betterApproach(int[] arr, int k) {
        int maxSubArrayCount = 0;
        int left = 0;
        int right = 0;
        while (left < arr.length) {
            int noOfOnes = 0;
            right = left;
            while (right < arr.length) {
                if (arr[right] == 1) {
                    noOfOnes++;
                } else if (arr[right] > k) {
                    break;
                }
                if (noOfOnes == k) {
                    maxSubArrayCount++;
                }
                right++;
            }
            left++;
        }

        return maxSubArrayCount;
    }
}
