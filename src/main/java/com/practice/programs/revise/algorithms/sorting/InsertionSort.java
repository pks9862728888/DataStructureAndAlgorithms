package com.practice.programs.revise.algorithms.sorting;

import java.util.Arrays;

/**
 * TC: O(n^2), AS: O(1)
 * Use case:
 * Sort array in the order which is already sorted in same order
 */
class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{6, 1, 4, 7, 2, 8, 9, 5})));
    }

    private static int[] insertionSort(int[] arr) {
        // Array of size 1 is already sorted, so we start from 1st index
        for (int i = 1; i < arr.length; i++) {
            int currEle = arr[i];
            // Shift elements towards right which are greater than currEle
            // so that currentEle can be inserted in correct position.
            int j = i - 1;
            while (j >= 0 && arr[j] > currEle) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currEle;
        }
        return arr;
    }
}
