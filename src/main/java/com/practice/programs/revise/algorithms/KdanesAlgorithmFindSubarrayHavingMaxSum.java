package com.practice.programs.revise.algorithms;

/**
 * TC: O(n), AS: O(1)
 */
class KdanesAlgorithmFindSubarrayHavingMaxSum {

    // -2 -3 4 -1 -2 1 5 -3 -> 7

    public static  long maxSubArraySumKdanesAlgorithm(int[] arr , int n) {
        // K'Danes algorithm
        long sumSoFar = arr[0];
        long currSum = arr[0];
        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            sumSoFar = Math.max(sumSoFar, currSum);
        }
        return sumSoFar;
    }

    public static  long maxSubArraySumKdanesAlgorithmIntuitiveApproach(int[] arr , int n) {
        // K'Danes algorithm
        // If currentSum is -ve, then adding any +ve integer will never increase the sum
        // So we will make it as 0
        // If currentSum is -ve, then adding any -ve integer will make it more -ve,
        // so no point in adding that element in sub-array
        long sumSoFar = arr[0];
        long currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (currSum > sumSoFar) {
                sumSoFar = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return sumSoFar;
    }
}
