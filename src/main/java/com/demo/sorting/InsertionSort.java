package com.demo.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 6, 5, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int k = i - 1;
            while (k >= 0 && curr < arr[k]) {
                arr[k + 1] = arr[k];
                k--;
            }
            arr[k + 1] = curr;

        }
    }
}
