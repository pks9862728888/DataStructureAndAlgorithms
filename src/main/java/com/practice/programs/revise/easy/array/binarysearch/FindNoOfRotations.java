package com.practice.programs.revise.easy.array.binarysearch;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/rotation_7449070?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class FindNoOfRotations {

    // 2, 3, 4, 1 -> res = 3

    public static int findKRotation(int []arr){
        int st = 0;
        int end = arr.length - 1;
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] < min) {
                min = arr[mid];
                minIdx = mid;
            }
            if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
                minIdx = mid;
                break;
            } else if (arr[mid] < arr[end]) { // left half contains min idx
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return minIdx;
    }
}
