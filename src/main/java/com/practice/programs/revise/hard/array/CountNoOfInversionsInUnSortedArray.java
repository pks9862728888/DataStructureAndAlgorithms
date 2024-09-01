package com.practice.programs.revise.hard.array;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array
 * TC: O(nlog n), AS: O(n)
 * Concepts:
 * ARRAY
 * SORTING
 * MERGE_SORT
 */
public class CountNoOfInversionsInUnSortedArray {

    public static void main(String[] args) {
        int arr[] = {1, 20, 6, 4, 5}; // 5
//        int arr[] = {15, 28, 11, 20, 14, 7, 14, 2, 15, 4, 22, 19, 17, 1, 26, 6, 20, 2, 6};  // 96
        System.out.println(numberOfInversions(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int numberOfInversions(int[] a) {
//         return brute(a, a.length);
        return countInvMergeSort(a, 0, a.length - 1);
    }

    private static int countInvMergeSort(int[] arr, int st, int end) {
        if (st >= end) {
            return 0;
        }
        int mid = st + (end - st) / 2;
        int invCount = countInvMergeSort(arr, st, mid);
        invCount += countInvMergeSort(arr, mid + 1, end);
        invCount += merge(arr, st, mid, mid + 1, end);
        return invCount;
    }

    private static int merge(int[] arr, int st1, int end1, int st2, int end2) {
        int[] temp = new int[end2 - st1 + 1];
        int ptr1 = st1;
        int ptr2 = st2;
        int ptrT = 0;
        int invCount = 0;
        while (ptr1 <= end1 || ptr2 <= end2) {
            if (ptr1 <= end1 && ptr2 <= end2) {
                if (arr[ptr1] <= arr[ptr2]) {
                    temp[ptrT++] = arr[ptr1++];
                } else {
                    // Since we are using merge sort, we are assuming left half is already sorted
                    // So if at a certain point we find inversion,
                    // we can assume that whole pending left half will result in inversion
                    invCount += end1 - ptr1 + 1;
                    System.out.printf("(%s, %s)%n", arr[ptr1], arr[ptr2]);
                    temp[ptrT++] = arr[ptr2++];
                }
            } else if (ptr1 <= end1) {
                temp[ptrT++] = arr[ptr1++];
            } else {
                temp[ptrT++] = arr[ptr2++];
            }
        }
        copyToOriginalArray(arr, temp, st1);
        return invCount;
    }

    private static void copyToOriginalArray(int[] arr, int[] temp, int stIdxArr) {
        for (int i = 0; i < temp.length; i++) {
            arr[stIdxArr + i] = temp[i];
        }
    }

    private static int brute(int[] a, int n) {
        int inversionCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

}
