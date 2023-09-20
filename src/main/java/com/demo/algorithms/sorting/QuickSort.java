package com.demo.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 1, 4, 7, 2, 8, 9, 5, 0, 3};
//        int p = lomutoPartition(arr, 0, arr.length - 1, arr.length - 1);
//        int p = hoarePartition(arr, 0, arr.length - 1);
//        System.out.println(p);

//        quickSortUsingLomutoPartition(arr, 0, arr.length - 1);
        quickSortUsingHoarePartition(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Claims that this is 3x faster than using Lomuto partition
     */
    private static void quickSortUsingHoarePartition(int[] arr, int l, int h) {
        if (l < h) {
            // Hoare partition will ensure that element in left half are <= elements in right half
            int p = hoarePartition(arr, l, h);

            // Call QS recursively
            quickSortUsingHoarePartition(arr, l, p);
            quickSortUsingHoarePartition(arr, p + 1, h);
        }
    }

    private static void quickSortUsingLomutoPartition(int[] arr, int l, int h) {
        if (l < h) {
            // Lomuto partition will place the pivot element in correct position and return it index
            int p = lomutoPartition(arr, l, h, h);

            // Call QS in left and right subtree
            quickSortUsingLomutoPartition(arr, l, p - 1);
            quickSortUsingLomutoPartition(arr, p + 1, h);
        }
    }

    /**
     * Unstable
     * Pivot element is always the first element in array.
     * Does not put pivot element in correct position.
     * It ensures ele left of partition are less than the elements right of partition.
     * More fast and efficient than Lomuto partition since replacements are less
     */
    private static int hoarePartition(int[] arr, int st, int end) {
        int pivot = arr[st];
        int i = st - 1;
        int j = end + 1;
        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);
            do {
                j--;
            } while(arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    /**
     * Unstable
     * Puts pivot element in correct position (all elements left of pivot are < pivot, all ele right of pivot are > pivot)
     */
    private static int lomutoPartition(int[] arr, int st, int end, int pivotIdx) {
        // Swap pivotIdx element to end
        swap(arr, pivotIdx, end);
        pivotIdx = end;

        // Swap logic
        // Initialize window of smaller element
        int windowSmaller = st - 1;
        for (int i = st; i <= end - 1; i++) {
            // If any smaller element exists than pivot element then increment the window of smaller element and swap
            if (arr[i] <= arr[pivotIdx]) {
                swap(arr, ++windowSmaller, i);
            }
        }
        // Put pivot element to the correct position (left of this will be <= pivot & the right will be > pivot)
        swap(arr, ++windowSmaller, pivotIdx);

        // Return index of pivot element
        return windowSmaller;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    /**
     * Stable
     */
    private static int naivePartition(int[] arr, int st, int end, int pivotIdx) {
        int[] temp = new int[end - st + 1];
        int ti = 0;
        // Putting all less than elements in left half
        for (int i = st; i <= end; i++) {
            if (arr[i] < arr[pivotIdx]) {
                temp[ti++] = arr[i];
            }
        }
        // Copy all the equal elements
        // For stability we are running a separate loop
        for (int i = st; i <= end; i++) {
            if (arr[i] == arr[pivotIdx]) {
                temp[ti++] = arr[i];
            }
        }
        // Marking new pivot position
        int newIdx = st + ti - 1;
        // Putting all greater than equal to elements in right half
        for (int i = st; i <= end; i++) {
            if (arr[i] > arr[pivotIdx]) {
                temp[ti++] = arr[i];
            }
        }
        // Copy to original array
        ti = 0;
        for (int i = st; i <= end; i++) {
            arr[i] = temp[ti++];
        }
        return newIdx;
    }
}
