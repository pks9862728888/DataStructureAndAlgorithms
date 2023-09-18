package com.practice.programs.revise.easy.array;

class FindEqualPartitionIndex {

    // 1 4 2 5 -> 2

    static int equalPartition(int n, long arr[]) {
        // Better solution:
        // Find prefixSum, suffixSum, if at ith idx, prefixSum = suffixSum, then that's partition index
        // TC: O(2n), AS: O(n)

        // Optimal solution:
        // Find suffix sum,
        // for each element update suffixSum by subtraction and generate prefixSum
        // TC: O(n), AS: O(1)
        long suffixSum = findSum(arr);
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            suffixSum -= arr[i];
            if (prefixSum == suffixSum) {
                return i;
            }
            prefixSum += arr[i];
        }
        return -1;
    }

    private static long findSum(long[] arr) {
        long s = 0;
        for (long e: arr) {
            s += e;
        }
        return s;
    }
}
