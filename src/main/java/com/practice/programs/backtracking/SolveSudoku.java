package com.practice.programs.backtracking;

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
        // Find next empty square
        int r = -1;
        int c = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) { // Find row & col idx where board is empty
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1 && c != -1) { // Go out of loop if board is empty
                break;
            }
        }

        // Return if all boxes are solved
        if (r == -1 && c == -1) {
            return true;
        }

        // Populate value by backtracking
        for (int i = 1; i <= n; i++) {
            if (isValidValueForSquare(m, r, c, n, i)) {
                m[r][c] = i;

                if (solveSudoku(m, n)) {
                    return true;
                } else { // Back tracking where if solving is not possible change n - 1 to 0 and put other values
                    m[r][c] = 0;
                }
            }
        }

        // Return value
        return false;
    }

    private static boolean isValidValueForSquare(int[][] m, int r, int c, int n, int val) {
        // Check whether row can be filled with value or not
        for (int i = 0; i < n; i++) {
            if (m[r][i] == val) {
                return false;
            }
        }

        // Check whether column can be filled with value or not
        for (int i = 0; i < n; i++) {
            if (m[i][c] == val) {
                return false;
            }
        }

        // Check whether box is valid or not
        int sqrt = (int) Math.sqrt(n);
        int startingRow = r - r % sqrt;
        int startingCol = c - c % sqrt;
        for (int i = startingRow; i < startingRow + sqrt; i++) {
            for (int j = startingCol; j < startingCol + sqrt; j++) {
                if (m[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
