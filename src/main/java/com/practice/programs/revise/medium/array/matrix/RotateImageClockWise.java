package com.practice.programs.revise.medium.array.matrix;

/**
 * https://leetcode.com/problems/rotate-image/
 * TC: O(m * n), AS: O(1)
 * Concepts:
 * Matrix
 */
public class RotateImageClockWise {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);
        flip(matrix, n);
    }

    private void transpose(int[][] matrix, int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void flip(int[][] matrix, int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - c - 1];
                matrix[r][n - c - 1] = temp;
            }
        }
    }
}
