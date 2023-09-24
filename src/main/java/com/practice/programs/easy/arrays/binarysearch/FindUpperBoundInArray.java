package com.practice.programs.easy.arrays.binarysearch;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FindUpperBoundInArray {

    // Find minimum idx of x, such that arr[idx] >= x
    // 2, 4, 6, 7, x = 5 -> ans = 2
    // 1, 2, 2, 3, x = 4 -> ans = 4 (if does not exist then send n

    public static int upperBound(int []arr, int x, int n){
        int st = 0, end = n - 1;
        int ub = n;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] <= x) {
                st = mid + 1;
            } else {
                ub = mid;
                end = mid - 1;
            }
        }
        return ub;
    }

}
