package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindNoOfExpressionsWhichCanBeEvaluatedToAGivenTarget {

    /**
     * TC: O(n * 2 * sum(nums[i]))
     * AS: O(n * 2 * sum(nums[i]))
     * concepts:
     * SHIFTING,
     * BOUNDED_ZERO_ONE_KNAPSACK
     * Sum can be -1000 to +1000 as per constraints, so key is shifted by 1000
     * Input:
     * noOfEle = 5 target = 3, arr = [1, 1, 1, 1, 1], ans = 5
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     */
    static int targetSumBetterApproach(int[] nums,int target){
        int n = nums.length;
        Integer[][] cache = new Integer[2 * 1000 + 1][n + 1];
        return possibleTargetSum(nums, target, n, 0, 0, cache);
    }

    static int possibleTargetSum(int[] nums, int target, int n, int currSum, int idx, Integer[][] cache) {
        if (idx == n) {
            return target == currSum ? 1 : 0;
        }
        int sumIdx = getSumIdx(currSum);
        if (Objects.isNull(cache[sumIdx][idx])) {
            int possibityMinus = possibleTargetSum(nums, target, n, currSum - nums[idx], idx + 1, cache);
            int possiblityPlus = possibleTargetSum(nums, target, n, currSum + nums[idx], idx + 1, cache);
            cache[sumIdx][idx] = possibityMinus + possiblityPlus;
        }
        return cache[sumIdx][idx];
    }

    private static int getSumIdx(int currSum) {
        return currSum + 1000;
    }

    /**
     * TC: O(n * 2 * sum(nums[i]) * k)
     * AS: O(n * 2 * sum(nums[i]) * k)
     * where k = length of cache key hash
     */
    static int targetSum(int[] nums,int target){
        int n = nums.length;
        Map<String, Integer> cache = new HashMap<>();
        return possibleTargetSum(nums, target, n, 0, 0, cache);
    }

    static int possibleTargetSum(int[] nums, int target, int n, int currSum, int idx, Map<String, Integer> cache) {
        if (idx == n) {
            return target == currSum ? 1 : 0;
        }
        String key = getKey(currSum, idx);
        if (!cache.containsKey(key)) {
            int possibityMinus = possibleTargetSum(nums, target, n, currSum - nums[idx], idx + 1, cache);
            int possiblityPlus = possibleTargetSum(nums, target, n, currSum + nums[idx], idx + 1, cache);
            cache.put(key, possibityMinus + possiblityPlus);
        }
        return cache.get(key);
    }

    private static String getKey(int currSum, int idx) {
        return currSum + "#" + idx;
    }
}
