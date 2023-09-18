package com.practice.programs.revise.medium.algorithms;

import java.util.List;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/sort-an-array-of-0s-1s-and-2s_892977?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class Sort012DutchNationalFlagAlgorithm {

    // BruteForce: Sort the array, TC: O(nlog n), AS: O(1)
    // Better: TC: O(2n), AS: O(1)
    //  Iterate over the array and keep track of 0s, 1s and 2s count
    //  Iterate over and put 0, 1 and 2 in correct place
    // Optimal: TC: O(1), AS: O(1)
    //  0 - (low - 1) -> 0
    //  low - (mid - 1) -> 1
    //  mid - high -> unsorted
    //  (high + 1) - (n - 1) -> 2

    public static void sortArray(List<Integer> arr, int n) {
        // sortInBetterApproach(arr, n);
        sortUsingDutchNationalFlagAlgorithm(arr, n);
    }

    private static void sortUsingDutchNationalFlagAlgorithm(List<Integer> arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr.get(mid) == 1) {
                mid++;
            } else {
                swap(arr, high, mid);
                high--;
            }
        }
    }

    private static void swap(List<Integer> arr, int idx1, int idx2) {
        int temp = arr.get(idx1);
        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);
    }

    private static void sortInBetterApproach(List<Integer> arr, int n) {
        int zc = 0;
        int oc = 0;
        int tc = 0;
        for(Integer e: arr) {
            if (e == 0) {
                zc++;
            } else if (e == 1) {
                oc++;
            } else {
                tc++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (zc-- > 0) {
                arr.set(i, 0);
            } else if (oc-- > 0) {
                arr.set(i, 1);
            } else {
                arr.set(i, 2);
                zc--;
            }
        }
    }
}
