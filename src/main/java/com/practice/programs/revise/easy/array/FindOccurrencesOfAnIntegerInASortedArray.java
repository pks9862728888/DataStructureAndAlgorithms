package com.practice.programs.revise.easy.array;

/**
 * TC: log n + log n, AS: O(1)
 */
class FindOccurrencesOfAnIntegerInASortedArray {

    // -1 2 2 2 4, k = 2 -> ans = 3
    // -1 2 2 2 4, k = 5, ans = 0

    static int countOccurrences(int n, int k, int a[]) {
        int firstIdx = findFirstIdx(a, k, n);
        if (firstIdx == -1) {
            return 0;
        }
        int lastIdx = findLastIdx(a, k, n);
        return lastIdx - firstIdx + 1;
    }

    private static int findFirstIdx(int[] arr, int k, int n) {
        int firstIdx = -1;
        int lb = 0;
        int ub = n - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == k) {
                firstIdx = mid;
                ub = mid - 1;
            } else if (arr[mid] > k) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return firstIdx;
    }

    private static int findLastIdx(int[] arr, int k, int n) {
        int lastIdx = -1;
        int lb = 0;
        int ub = n - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == k) {
                lastIdx = mid;
                lb = mid + 1;
            } else if (arr[mid] > k) {
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return lastIdx;
    }
}
