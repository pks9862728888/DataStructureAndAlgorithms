package com.practice.programs.revise.hard.matrix;

import java.util.List;

class FindKthSmallestEleInMatrix {

    // 1  5  9
    // 10 11 13
    // 12 13 15
    // k = 8, res = 13
    // Explanation: flattened array = 1 5 9 10 11 12 13 13 15

    /**
     * TC: n log O(maxEleInMatrix), AS: O(1)
     */
    static int kthSmallestElementInMatrix(List<List<Integer>> matrix, int k) {
        // Apply binary search in range [min(matrix), max(matrix)]
        // if countEleLessOrEqual of mid element of matrix >= k,
        //      store mid ele as possible ans and continue searching in left side
        // else
        //      continue searching in right side
        int st = matrix.get(0).get(0);
        int end = matrix.get(matrix.size() - 1).get(matrix.size() - 1);
        int kthSmallest = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int countEleLessOrEqual = findEleCountLessThanEqualTo(matrix, mid);
            if (countEleLessOrEqual >= k) {
                kthSmallest = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return kthSmallest;
    }

    private static int findEleCountLessThanEqualTo(List<List<Integer>> matrix, int midEle) {
        int count = 0;
        for (List<Integer> row: matrix) {
            if (midEle >= row.get(row.size() - 1)) {
                count += row.size();
            } else if (midEle >= row.get(0)) {
                for (Integer ele: row) {
                    if (ele <= midEle) {
                        count++;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return count;
    }
}
