package com.practice.programs.easy.twopointer;

/**
 * TC: O(n), AS: O(1)
 * Approach: Two Pointer approach
 */
public class FindIfPairExistsWithGivenSumInSortedArray {

    static boolean twoSumInSortedArray(int lengthOrArr, int arr[], int k) {
        int st = 0;
        int end = arr.length - 1;
        while (st < end) {
            int sum = arr[st] + arr[end];
            if (sum == k) {
                return true;
            } else if (sum > k) {
                end--;
            } else {
                st++;
            }
        }
        return false;
    }
}
