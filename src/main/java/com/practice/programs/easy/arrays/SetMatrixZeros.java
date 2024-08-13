package com.practice.programs.easy.arrays;

import java.util.*;

/**
 * TC: O(1) - lookup in hashset + O(m*n) - for finding 0 row and col + O(m*n) - for updating = O(m * n)
 * AS: O(m + n) - for storing unique 0 rows and column for update
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/description/">Practice Link</a>
 */
public class SetMatrixZeros {

    public void setZeroes(int[][] m) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        // Find rows and columns which should be updated
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }

        // Update to zero
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (r.contains(i) || c.contains(j)) {
                    m[i][j] = 0;
                }
            }
        }
    }

    /**
     * TC: O(m * n), AS: O(1)
     * https://leetcode.com/problems/set-matrix-zeroes/
     * Idea is to use first row and column as indicator whether row & column should be marked as 0
     */
    public void setZeroesWithoutUsingAuxiliarySpace(int[][] m) {
        int rowLen = m.length;
        int colLen = rowLen > 0 ? m[0].length : 0;
        // Determine which row and column should be marked as zero
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (m[row][col] == 0) { // mark 0 in first row and first col
                    m[0][col] = 0;
                    m[row][0] = 0;
                    if (row == 0) {
                        firstRowZero = true;
                    }
                    if (col == 0) {
                        firstColZero = true;
                    }
                }
            }
        }
        updateRowNColZeroExclFirstRowNCol(m, rowLen, colLen);
        updateFirstRowZero(m, firstRowZero, colLen);
        updateFirstColZero(m, firstColZero, rowLen);
    }

    private static void updateRowNColZeroExclFirstRowNCol(int[][] m, int rowLen, int colLen) {
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if ((row != 0 && col != 0) && (m[row][0] == 0 || m[0][col] == 0)) {
                    m[row][col] = 0;
                }
            }
        }
    }

    private static void updateFirstColZero(int[][] m, boolean firstColZero, int rowLen) {
        if (firstColZero) {
            for (int row = 0; row < rowLen; row++) {
                m[row][0] = 0;
            }
        }
    }

    private static void updateFirstRowZero(int[][] m, boolean firstRowZero, int colLen) {
        if (firstRowZero) {
            for (int col = 0; col < colLen; col++) {
                m[0][col] = 0;
            }
        }
    }

}
