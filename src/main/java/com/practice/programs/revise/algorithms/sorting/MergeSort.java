package com.practice.programs.revise.algorithms.sorting;

import java.util.Arrays;

/**
 * TC: O(nlog n), AS: O(n)
 * Divide array into halves and then merge (divide and conquer)
 */
class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[] {6, 1, 4, 7, 2, 8, 9, 5, 0, 3})));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            divideAndMerge(arr, 0, arr.length - 1);
        }
        return arr;
    }

    private static void divideAndMerge(int[] arr, int st, int end) {
        // Divide arr into two halves till elemental split, TC: O(log n)
        if (st >= end) {
            return;
        }
        int mid = (st + end) / 2;
        divideAndMerge(arr, st, mid);
        divideAndMerge(arr, mid + 1, end);

        // Merge the sorted arrays
        mergeSortedHalves(arr, st, mid, mid + 1, end);
    }

    /**
     * TC: O(n), AS: O(n)
     */
    private static void mergeSortedHalves(int[] arr, int st1, int end1, int st2, int end2) {
        // Merge two sorted halves into temp array
        int[] temp = new int[end2 - st1 + 1];
        int p1 = st1;
        int p2 = st2;
        int pt = 0;
        while (p1 <= end1 || p2 <= end2) {
            if (p1 <= end1 && p2 <= end2) {
                temp[pt++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            } else if (p1 <= end1) {
                temp[pt++] = arr[p1++];
            } else {
                temp[pt++] = arr[p2++];
            }
        }

        // Copy temp array over to original array
        for (int i = 0; i < temp.length; i++) {
            arr[st1 + i] = temp[i];
        }
    }
}
