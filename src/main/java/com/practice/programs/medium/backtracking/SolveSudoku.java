package com.practice.programs.medium.backtracking;

import com.utils.Printer;

public class SolveSudoku implements Printer {

    public static void main(String[] args) {
        int[][] m = {
                {0,2,3,0},
                {0,0,0,1},
                {0,1,0,0},
                {2,4,0,0}};
        System.out.println("Before: ");
        Printer.printMatrix(m);
        if (solveSudoku(m, m.length)) {
            System.out.println("After: ");
            Printer.printMatrix(m);
        } else {
            System.out.println("Sudoku cannot be solved :(");
        }
    }

    private static boolean solveSudoku(int[][] m, int n) {
        // Find empty slot
        int r = 0;
        int c = 0;
        for (r = 0; r < n; r++) {
            for (c = 0; c < n; c++) {
                if (m[r][c] == 0) {
                    break;
                }
            }
            if (c != n) {
                break;
            }
        }

        // Return if sudoku is solved (empty slot is not found)
        if (r == n && c == n) {
            return true;
        }

        // Solve sudoku using backtracking
        for (int val = 1; val <= n; val++) {
            if (isValid(m, r, c, n, val)) {
                m[r][c] = val;

                if (solveSudoku(m, n)) {
                    return true;
                } else {
                    m[r][c] = 0; // Backtracking
                }
            }
        }
        return false;
    }
    private static boolean isValid(int[][] m, int r, int c, int n, int val) {
        // Check row & column
        for (int i = 0; i < n; i++) {
            if (m[i][c] == val) { // row check
                return false;
            }
            if (m[r][i] == val) { // col check
                return false;
            }
        }

        // Check sub-square
        int sqrt = (int) Math.sqrt(n);
        int stR = r - r % sqrt;
        int stC = c - c % sqrt;
        for (int i = stR; i < stR + sqrt; i++) {
            for (int j = stC; j < stC + sqrt; j++) {
                if (m[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
