package com.practice.programs.revise.medium.array.binarysearch;

/**
 * TC: O((log 10^9) * m log n)  AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * Intuition: For median idx, count of element in left is always <= element at median idx
 */
class FindMedianInRowWiseSortedMatrix {

    // 1 5 7 9 11
    // 2 3 4 8 9
    // 4 11 14 19 20
    // 6 10 22 99 100
    // 7 15 17 24 28
    // ans = 10

    public static int findMedian(int matrix[][], int m, int n) {
        int st = findMin(matrix);
        int end = findMax(matrix);
        int medianIdx = (m * n) / 2;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int countEleLessThanEqual = countEleLessThan(matrix, mid);
            if (countEleLessThanEqual <= medianIdx) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return st;
    }

    private static int countEleLessThan(int[][] m, int target) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            count += upperBound(m[i], target);
        }
        return count;
    }

    private static int upperBound(int[] arr, int target) {
        int st = 0;
        int end = arr.length - 1;
        int res = end + 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] > target) {
                res = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return res;
    }

    private static int findMin(int[][] m) {
        int min = Integer.MAX_VALUE;
        for (int[] r: m) {
            min = Math.min(min, r[0]);
        }
        return min;
    }

    private static int findMax(int[][] m) {
        int max = Integer.MIN_VALUE;
        for (int[] r: m) {
            max = Math.max(max, r[r.length - 1]);
        }
        return max;
    }

}
