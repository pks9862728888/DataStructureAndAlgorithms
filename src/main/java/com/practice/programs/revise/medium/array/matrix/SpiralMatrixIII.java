package com.practice.programs.revise.medium.array.matrix;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 * TC: O(m * n), AS: (m * n * 2)
 * Concepts:
 * MATRIX
 */
public class SpiralMatrixIII {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int targetSize = rows * cols;
        int[][] mat = new int[targetSize][2];
        int r = rStart;
        int c = cStart;
        int targetMoves = 1;
        int dirChanged = 2;
        int currSize = 0;
        setValueInMatrix(mat, r, c, currSize++);
        while (currSize < targetSize) {
            for (int[] dir: dirs) {
                for (int i = 1; i <= targetMoves && currSize < targetSize; i++) {
                    r += dir[0];
                    c += dir[1];
                    if (isValid(r, c, rows, cols)) {
                        setValueInMatrix(mat, r, c, currSize);
                        currSize++;
                    }
                }
                dirChanged--;
                if (dirChanged == 0) {
                    dirChanged = 2;
                    targetMoves++;
                }
                if (currSize == targetSize) {
                    break;
                }
            }
        }
        return mat;
    }

    private void setValueInMatrix(int[][] mat, int r, int c, int currSize) {
        mat[currSize][0] = r;
        mat[currSize][1] = c;
    }

    private boolean isValid(int r, int c, int nRows, int nCols) {
        return r >= 0 && c >= 0 && r < nRows && c < nCols;
    }
}
