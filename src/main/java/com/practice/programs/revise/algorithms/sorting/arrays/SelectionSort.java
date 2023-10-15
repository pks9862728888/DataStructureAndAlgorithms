package com.practice.programs.revise.algorithms.sorting.arrays;

import java.util.Arrays;

/**
 * TC: O(n^2), AS: O(1)
 * For each element, find the minimum element and swap in the start of array
 */
class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{6, 1, 4, 7, 2, 8, 9, 5, 0})));
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
