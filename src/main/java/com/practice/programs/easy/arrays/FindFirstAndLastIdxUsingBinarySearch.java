package com.practice.programs.easy.arrays;

import java.util.ArrayList;

public class FindFirstAndLastIdxUsingBinarySearch {

    /**
     * GFG (basic)
     * TC: O(log n)
     * AS: O(1)
     */
    public static void main(String[] args) {
        System.out.println(find(new long[]{1, 3, 5, 5, 5, 5, 67, 123, 125}, 5)); // 2, 5
    }

    private static ArrayList<Long> find(long arr[], int x) {
        ArrayList<Long> al = new ArrayList<>();

        al.add(findFirstIdx(arr, 0, arr.length - 1, x));
        if (al.get(0) == -1) {
            al.add(-1L);
        } else {
            al.add(findLastIdx(arr, al.get(0), arr.length - 1, x));
        }

        return al;
    }

    private static long findFirstIdx(long[] arr, long st, long end, long x) {
        while (st <= end) {
            int mid = (int) (st + (end - st) / 2);

            if (arr[mid] == x && (mid == 0 || arr[mid - 1] < x)) {
                return mid;
            } else if (arr[mid] == x) {
                end = mid - 1;
            } else if (arr[mid] < x) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1L;
    }

    private static long findLastIdx(long[] arr, long st, long end, long x) {
        while (st <= end) {
            int mid = (int) (st + (end - st) / 2);

            if (arr[mid] == x && (mid == arr.length - 1 || arr[mid + 1] > x)) {
                return mid;
            } else if (arr[mid] == x) {
                st = mid + 1;
            } else if (arr[mid] < x) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1L;
    }
}
