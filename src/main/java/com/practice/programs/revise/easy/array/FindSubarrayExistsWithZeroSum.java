package com.practice.programs.revise.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * TC: O(n), AS: O(n)
 * Intuition:
 * Calculate prefix sum
 * If currentSum is 0 then that means subArray found
 * If currentSum matches with any other previous prefix sum that means sum of elements in that interval is 0
 */
class FindSubarrayExistsWithZeroSum {

    public static void main(String[] args) {
        System.out.println(subarraySumZero(new int[]{1, -1}));
    }

    public static String subarraySumZero(int[] arr) {
        Set<Long> prefixSumSet = new HashSet<>();
        prefixSumSet.add(0L);
        long sumSoFar = 0;
        for (long e : arr) {
            sumSoFar += e;
            if (!prefixSumSet.add(sumSoFar)) {
                return "Yes";
            }
        }
        return "No";
    }
}
