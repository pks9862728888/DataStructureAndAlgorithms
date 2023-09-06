package com.practice.programs.revise.easy.array;

/**
 * TC: O(n^2), AS: O(1)
 */
public class RotateArrayByNinetyDegreeClockwise {

    public static void main(String[] args) {
        int matrixSize = 4;
        int[][] matrix = new int[matrixSize][matrixSize];
        int no = 1;
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                matrix[i][j] = no++;
            }
        }

        rotateImage(matrix);
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateImage(int[][] matrix) {
        // Create transpose of matrix
        transposeMatrix(matrix, matrix.length);

        // Reverse data rows
        reverseRows(matrix, matrix.length);
    }

    private static void transposeMatrix(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
    }

    private static void reverseRows(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = m[i][j];
                m[i][j] = m[i][n - j - 1];
                m[i][n - j - 1] = t;
            }
        }
    }

}
