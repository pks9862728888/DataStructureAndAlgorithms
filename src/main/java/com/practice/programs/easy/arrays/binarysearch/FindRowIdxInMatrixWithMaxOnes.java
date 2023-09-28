package com.practice.programs.easy.arrays.binarysearch;

import java.util.ArrayList;

/**
 * TC: O (m * log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/row-of-a-matrix-with-maximum-ones_982768?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
public class FindRowIdxInMatrixWithMaxOnes {

    // 1  1  1
    // 0  0  1
    // 0  0  0
    // Ans = 0

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int maxOneCount = 0;
        int maxOneIdx = -1;
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            int oneCount = countOne(row);
            if (oneCount > maxOneCount) {
                maxOneCount = oneCount;
                maxOneIdx = i;
                if (maxOneCount == row.size()) {
                    break;
                }
            }
        }

        return maxOneIdx;
    }

    private static int countOne(ArrayList<Integer> row) {
        int st = 0;
        int end = row.size() - 1;
        int oneIdx = row.size();
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (row.get(mid) == 1) {
                oneIdx = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return row.size() - oneIdx;
    }
}
