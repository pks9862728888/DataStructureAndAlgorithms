package com.practice.programs.revise.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[] {6, 1, 4, 7, 2, 8, 9, 5, 0, 3})));
    }

    private static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int st, int end) {
        if (st >= end) {
            return;
        }
        // Hoare partition will ensure that element in left half are <= elements in right half
        // But it will not put pivot element in correct position
        int pivotIdx = findPivotHaorePartition(arr, st, end);
        quickSort(arr, st, pivotIdx);
        quickSort(arr, pivotIdx + 1, end);
    }


    /**
     * Unstable
     * Pivot element is always the first element in array.
     * Does not put pivot element in correct position.
     * It ensures ele left of partition are less than the elements right of partition.
     * More fast and efficient than Lomuto partition since replacements are less
     */
    private static int findPivotHaorePartition(int[] arr, int st, int end) {
        int pivotEle = arr[st];
        int l = st;
        int r = end;
        while (l < r) {
            while (arr[l] < pivotEle) {
                l++;
            }
            while (arr[r] > pivotEle) {
                r--;
            }
            swap(arr, l, r);
        }
        return r;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }
}
