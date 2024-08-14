package com.practice.programs.revise.medium.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/submissions/1354918545/
 * TC: O(n^2), AS: O(n^2)
 * Concept:
 * MATRIX
 */
class PrintMatrixInSpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = rowLen > 0 ? matrix[0].length : 0;
        int colLeft = 0;
        int colRight = colLen - 1;
        int rowTop = 0;
        int rowBottom = rowLen - 1;
        int itemsSize = rowLen * colLen;
        while (shouldTraverseMore(res, itemsSize)) {
            // Go left to right
            for(int i = colLeft; i <= colRight; i++) {
                res.add(matrix[rowTop][i]);
            }
            rowTop++;
            // Go top to bottom
            for (int i = rowTop; i <= rowBottom && shouldTraverseMore(res, itemsSize); i++) {
                res.add(matrix[i][colRight]);
            }
            colRight--;
            // Go right to left
            for (int i = colRight; i >= colLeft && shouldTraverseMore(res, itemsSize); i--) {
                res.add(matrix[rowBottom][i]);
            }
            rowBottom--;
            // Go bottom to top
            for (int i = rowBottom; i >= rowTop && shouldTraverseMore(res, itemsSize); i--) {
                res.add(matrix[i][colLeft]);
            }
            colLeft++;
        }
        return res;
    }

    private static boolean shouldTraverseMore(List<Integer> res, int itemsSize) {
        return res.size() < itemsSize;
    }

    static int[][] spiralMatrixII(int n) {
        int[][] mat = new int[n][n];
        int count = 1;
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        while (count <= n * n) {
            // Traverse right
            for (int i = l; i <= r; i++) {
                mat[t][i] = count++;
            }
            t++;

            // Traverse down
            for (int i = t; i <= b; i++) {
                mat[i][r] = count++;
            }
            r--;

            // Traverse left
            for (int i = r; i >= l; i--) {
                mat[b][i] = count++;
            }
            b--;

            // Traverse up
            for (int i = b; i >= t; i--) {
                mat[i][l] = count++;
            }
            l++;
        }
        return mat;
    }
}
