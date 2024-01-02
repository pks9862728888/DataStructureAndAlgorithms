package com.practice.programs.revise.algorithms.sorting.arrays;

/**
 * TC: O(n^2), AS: O(1)
 * Unstable algorithm
 * If numbers are in range 0 - n or 1 - n, then cyclic sort can be used to find the missing no / duplicate no
 */
public class CyclicSort {

    // find first missing no
    public static int findMissingNumber(int[] arr) {
        return withCyclicSort(arr);
        // return withoutCyclicSort(arr);
    }

    private static int withCyclicSort(int[] arr) {
        // cyclic sort
        cyclicSort(arr);

        // find missing no
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return 0;
    }

    private static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                int otherIdx = arr[i];
                if (otherIdx >= arr.length || otherIdx == arr[otherIdx]) {
                    break;
                }
                // swap
                int temp = arr[i];
                arr[i] = arr[otherIdx];
                arr[otherIdx] = temp;
            }
        }
    }

    private static int withoutCyclicSort(int[] arr) {
        int maxNo = 0;
        int sum = 0;
        for (int e: arr) {
            sum += e;
            if (e > maxNo) {
                maxNo = e;
            }
        }
        return maxNo * (maxNo + 1) / 2 - sum;
    }
}
