package com.practice.programs.easy.arrays.binarysearch;

/**
 * TC: O(n log n), AS: (1)
 * <a href="https://www.codingninjas.com/codestudio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class SearchInsertPositionInSortedArray {

    public static int searchInsert(int [] arr, int m){
        if (arr.length == 0) {
            return 0;
        }
        int st = 0;
        int end = arr.length - 1;
        int idx = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] >= m) {
                idx = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return idx == -1 ? arr.length : idx;
    }

}
