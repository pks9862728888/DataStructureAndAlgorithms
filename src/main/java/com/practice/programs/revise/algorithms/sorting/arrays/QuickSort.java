package com.practice.programs.revise.algorithms.sorting.arrays;

import java.util.Arrays;

/**
 * TC: O(n^2), AS: O(n)
 */
public class QuickSort {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(quickSort(new int[]{0, 1, 1, 2, 0, 5})));
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
//    System.out.println("pivotIdx: " + pivotIdx);
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
  private static int findPivotHaorePartition(int[] arr, int l, int h) {
    int pivot = arr[l];
    int lp = l - 1;
    int rp = h + 1;
    while (true) {
      do {
        lp++;
      } while (arr[lp] < pivot);
      do {
        rp--;
      } while (arr[rp] > pivot);
      if (lp >= rp) return rp;
      swap(arr, lp, rp);
    }
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int t = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = t;
  }
}
