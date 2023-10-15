package com.practice.programs.revise.algorithms.sorting.arrays;

import java.util.Arrays;


/**
 * TC: O(n^2), AS: O(1)
 * Swap adjacent elements if it's not already sorted
 */
class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{6, 1, 4, 7, 2, 8, 9, 5, 0})));
    }

    private static int[] bubbleSort(int[] arr) {
        int iteration = 0;
        while (++iteration < arr.length) {
            for (int i = 0; i < arr.length - iteration; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
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
