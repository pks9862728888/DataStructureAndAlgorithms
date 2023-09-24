package com.practice.programs.easy.arrays.binarysearch;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/lower-bound_8165382?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FindLowerBoundInArray {

    // Find minimum idx of x, such that arr[idx] >= x
    // 1, 2, 2, 3, x = 0 -> ans = 0
    // 1, 2, 2, 3, x = 4 -> ans = 4

    public static int lowerBound(int []arr, int n, int x) {
        int st = 0, end = n - 1;
        int lb = n;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] >= x) {
                lb = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return lb;
    }

}
