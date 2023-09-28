package com.practice.programs.easy.arrays.binarysearch;

/**
 * TC: O (log (m + n)), AS: O(1)
 */
class SearchInASorted2DMatrix {

    // 1 3 7
    // 10 12 15
    // 19 20 21
    // Search: 12
    // Res: true

    public static boolean searchElement(int [][] m, int target) {
        int rowSt = 0;
        int rowEnd = m.length - 1;
        while (rowSt <= rowEnd) {
            int mid = rowSt + (rowEnd - rowSt) / 2;
            int[] row = m[mid];
            if (target < row[0]) {
                rowEnd = mid - 1;
            } else if (target > row[row.length - 1]) {
                rowSt = mid + 1;
            } else {
                if (found(row, target)) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private static boolean found(int[] row, int target) {
        int st = 0;
        int end = row.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }
}
