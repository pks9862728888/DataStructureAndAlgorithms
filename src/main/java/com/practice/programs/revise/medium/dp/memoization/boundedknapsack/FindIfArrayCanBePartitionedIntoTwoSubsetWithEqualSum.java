package com.practice.programs.revise.medium.dp.memoization.boundedknapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindIfArrayCanBePartitionedIntoTwoSubsetWithEqualSum {

    /**
     * TC: O(n * halfSum), AS: O(n * halfSum)
     */
    static int equalSumPartitionOptimal(int n, int[] arr) {
        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        if (sum % 2 != 0) { // Sum not possible
            return 0;
        }
        int halfSum = sum / 2;
        Map<String, Boolean> cache = new HashMap<>();
        return canPartitionOptimal(n, arr, halfSum, 0, cache) ? 1 : 0;
    }

    static boolean canPartitionOptimal(int n, int[] arr, int halfSum, int currIdx, Map<String, Boolean> cache) {
        if (halfSum == 0) {
            return true;
        }
        if (currIdx == n) {
            return false;
        }
        String key = halfSum + "#" + currIdx;
        if (!cache.containsKey(key)) {
            boolean canPartitionTake = canPartitionOptimal(n, arr, halfSum - arr[currIdx], currIdx + 1, cache);
            boolean canPartitionDontTake = canPartitionTake ||
                    canPartitionOptimal(n, arr, halfSum, currIdx + 1, cache);
            cache.put(key, canPartitionTake || canPartitionDontTake);
        }
        return cache.get(key);
    }

    /**
     * TC: O(n * halfSum1 * halfSum2), AS: O(n * halfSum1 * halfSum2)
     */
    static int equalSumPartitionNonOptimal(int n,int[] arr){
        Map<String, Boolean> cache = new HashMap<>();
        return canPartition(n, arr, 0, 0, 0, cache) ? 1 : 0;
    }

    static boolean canPartition(
            int n, int[] arr, int sumPar1, int sumPar2, int currIdx, Map<String, Boolean> cache) {
        if (currIdx == n) {
            return sumPar1 == sumPar2;
        }
        String key = getKey(sumPar1, sumPar2, currIdx);
        if (!cache.containsKey(key)) {
            boolean canPar1Take = canPartition(n, arr, sumPar1 + arr[currIdx], sumPar2, currIdx + 1, cache);
            boolean canPar2Take = canPar1Take ||
                    canPartition(n, arr, sumPar1, sumPar2 + arr[currIdx], currIdx + 1, cache);

            cache.put(key, canPar1Take || canPar2Take);
        }
        return cache.get(key);
    }

    private static String getKey(int sum1, int sum2, int currIdx) {
        return sum1 + "#" + sum2 + "#" + currIdx;
    }
}
