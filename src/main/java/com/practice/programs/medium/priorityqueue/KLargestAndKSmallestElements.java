package com.practice.programs.medium.priorityqueue;

import java.util.Arrays;

public class KLargestAndKSmallestElements {

    /**
     * Approach 1: TC: O(n log n)
     * - Sort the array: n log n
     * - Find k elements: k
     *
     * Approach 2: TC: O(n log k)
     * - Maintain PQ for first k elements: k log k
     * - For next n - k elements re-heap with first k elements: (n - k) log k
     * So overall TC = k log k + (n - k) log k = n log k
     */
    public static void main(String[] args) {
        int actArr[] = getArr();
        Arrays.sort(actArr);
        System.out.println("ACTUAL ARR: " + Arrays.toString(actArr));

        // Find K largest elements
        int arr[] = getArr();
        int k = 3;
        System.out.println("K LARGEST ELE: " + Arrays.toString(findKLargestElements(arr, k)));

        // Find K smallest elements
        arr = getArr();
        k = 3;
        System.out.println("K SMALLEST ELE: " + Arrays.toString(findKSmallestElements(arr, k)));
    }

    private static int[] findKSmallestElements(int[] arr, int k) {
        if (arr == null || arr.length <= 1 || k >= arr.length) {
            return arr;
        }

        // Create Max Heap for first k elements
        for (int i = 1; i < k; i++) {
            int ci = i;
            int pi = (ci - 1) / 2;

            while (pi >= 0 && arr[pi] < arr[ci]) {
                swap(arr, pi, ci);
                ci = pi;
                pi = (ci - 1) / 2;
            }
        }

        // For next (n - k) elements swap & re-heapify
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);

                // Re-heapify
                int pi = 0;
                int ci1 = 1;
                int ci2 = 2;
                while (true) {
                    int si;
                    if (ci1 < k && ci2 < k) {
                        si = arr[ci1] > arr[ci2] ? ci1 : ci2;
                    } else if (ci1 < k) {
                        si = ci1;
                    } else {
                        break;
                    }

                    if (arr[pi] < arr[si]) {
                        swap(arr, pi, si);
                        pi = si;
                    } else {
                        break;
                    }

                    ci1 = pi * 2 + 1;
                    ci2 = pi * 2 + 2;
                }
            }
        }

        // Extract first k elements
        return createArr(arr, 0, k);
    }

    private static int[] findKLargestElements(int[] arr, int k) {
        if (arr == null || arr.length <= 1 || k >= arr.length) {
            return arr;
        }

        // Create Min Heap for first k elements
        for (int i = 1; i < k; i++) {
            int ci = i;
            int pi = (ci - 1) / 2;

            while (pi >= 0 && arr[pi] > arr[ci]) {
                swap(arr, pi, ci);
                ci = pi;
                pi = (ci - 1) / 2;
            }
        }

        // For next (n - k) elements swap & re-heapify
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                swap(arr, i, 0);

                // Re-heapify
                int pi = 0;
                int ci1 = 1;
                int ci2 = 2;
                while (true) {
                    int si;
                    if (ci1 < k && ci2 < k) {
                        si = arr[ci1] < arr[ci2] ? ci1 : ci2;
                    } else if (ci1 < k) {
                        si = ci1;
                    } else {
                        break;
                    }

                    if (arr[pi] > arr[si]) {
                        swap(arr, pi, si);
                        pi = si;
                    } else {
                        break;
                    }

                    ci1 = pi * 2 + 1;
                    ci2 = pi * 2 + 2;
                }
            }
        }

        // Extract first k elements
        return createArr(arr, 0, k);
    }

    // endIdx = inclusive
    private static int[] createArr(int arr[], int stIdx, int endIdx) {
        return Arrays.copyOfRange(arr, stIdx, endIdx);
    }
    private static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int[] getArr() {
        return new int[] {2, 4, 1, 7, 9, 2, 10};
    }
}
