package com.demo.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 5, 4, 3};
        mergeSortArr(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortArr(int[] arr, int st, int end) {
        // There should be at least 2 elements for calling merge function
        if (st < end) {
            int mid = st + (end - st) / 2;
            // Call mergesort recursively on left and right half
            // After that call the merge function on the two sorted halves
            mergeSortArr(arr, st, mid);
            mergeSortArr(arr, mid + 1, end);
            mergeArr(arr, st, end, mid);
        }
    }

    private static void mergeArr(int[] arr, int st, int end, int mid) {
        // Set auxiliary arrays
        int[] left = Arrays.copyOfRange(arr, st, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
        int ls = 0;
        int le = left.length - 1;
        int rs = 0;
        int re = right.length - 1;
        // Merge into original array
        for (int i = st; i <= end; i++) {
            if (ls <= le && rs <= re) {
                if (left[ls] <= right[rs]) {
                    arr[i] = left[ls++];
                } else {
                    arr[i] = right[rs++];
                }
            } else if (ls <= le) {
                arr[i] = left[ls++];
            } else {
                arr[i] = right[rs++];
            }
        }
    }
}
