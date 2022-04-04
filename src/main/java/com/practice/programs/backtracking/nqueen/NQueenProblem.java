package com.practice.programs.backtracking.nqueen;

import com.utils.Printer;

public class NQueenProblem implements Printer {

    public static void main(String[] args) {
//        placeNQueen(3);
        placeNQueen(4);
    }

    private static boolean placeNQueen(int n) {
        int[][] placement = new int[n][n];
        if (placeNQueen(placement, 0, n)) {
            Printer.printMatrix(placement);
            return true;
        } else {
            System.out.println("Placement not possible");
            return false;
        }
    }

    private static boolean placeNQueen(int[][] m, int colIdx, int n) {
        if (colIdx >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {  // row
            if (isSafeToPlaceQueen(m, i, colIdx, n)) {
                m[i][colIdx] = 1;
                if (placeNQueen(m, colIdx + 1, n)) {
                    return true;
                }
                m[i][colIdx] = 0;
            }
        }
        return false;
    }

    private static boolean isSafeToPlaceQueen(int[][] m, int rowIdx, int colIdx, int n) {
        // check whether row / column is filled
        for (int i = 0; i < n; i++) {
            if (m[rowIdx][i] == 1) {  // check whether row has 1
                return false;
            }
            if (m[i][colIdx] == 1) { // check whether column has 1
                return false;
            }
        }

        for (int i = rowIdx, j = colIdx; i >= 0 && j >= 0; i--, j--) { // upper left diagonal
            if (m[i][j] == 1) {
                return false;
            }
        }

        for (int i = rowIdx, j = colIdx; i < n && j >= 0; i++, j--) {  // bottom left diagonal
            if (m[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
