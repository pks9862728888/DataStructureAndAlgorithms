package com.practice.programs.revise.medium.array.binarysearch;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/rotated-array_1093219?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FindMinimumInRotatedSortedArray {

    // 35 43 45 1 2 9 12 13 19 20 26 28 29 32, res = 1;

    public static int findMin(int []arr) {
        int st = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[st] <= arr[end]) { // whole array is sorted
                min = Math.min(min, arr[st]);
                break;
            } else {
                min = Math.min(min, arr[mid]);
                if (arr[st] > arr[mid]) { // rotation lies in left half
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        return min;
    }
}
