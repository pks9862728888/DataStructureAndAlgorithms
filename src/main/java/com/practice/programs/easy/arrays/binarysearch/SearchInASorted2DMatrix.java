package com.practice.programs.easy.arrays.binarysearch;

/**
 * TC: O (m * log n), AS: O(1)
 */
class SearchInASorted2DMatrix {

    // 1 3 7
    // 10 12 15
    // 19 20 21
    // Search: 12
    // Res: true

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr: matrix) {
            int endIdx = arr.length - 1;
            if (arr[0] > target) {
                break;
            } else if (target >= arr[0] && target <= arr[endIdx]) {
                if(isFound(arr, endIdx, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFound(int[] arr, int endIdx, int target) {
        int lb = 0;
        int ub = endIdx;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        return false;
    }
}
