package com.practice.programs.revise.easy.array;

/**
 * TC: O(n), AS: O(1)
 * Approach: Sliding Window
 */
class FindMaxSubarraySumOfSizeK {

    // 100 200 300 400
    // K = 2
    // ans = 300 + 400 = 700

    static int maximumSubarraySumSizeK(int[] arr, int n, int k) {
        int maxSum = findSum(arr, k);
        int currSum = maxSum;
        int left = 0;
        int right = k;
        while (right < n) {
            currSum = currSum - arr[left] + arr[right];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            left++;
            right++;
        }
        return maxSum;
    }

    private static int findSum(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
