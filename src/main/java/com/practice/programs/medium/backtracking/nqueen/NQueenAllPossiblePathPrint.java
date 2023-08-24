package com.practice.programs.medium.backtracking.nqueen;

public class NQueenAllPossiblePathPrint {

    public static void main(String[] args) {
        placeNQueens(4);
    }

    public static void placeNQueens(int n) {
        int[][] path = new int[n][n];
        printPath(0, n, path);
    }

    private static void printPath(int r, int n, int[][] path) {
        if (r >= n) {
            print(n, path);
            return;
        }

        // Trace all columns of particular row and check whether queen can be placed
        for (int i = 0; i < n; i++) {
            if (canPlace(r, i, n, path)) {
                path[r][i] = 1;
                printPath(r + 1, n, path);

                // Resetting position for backtracking
                path[r][i] = 0;
            }
        }
    }

    private static boolean canPlace(int r, int c, int n, int[][] path) {
        if (r >= n || c >= n) {
            return false;
        }
        for (int i = 0; i < r; i++) {
            // Check for column upto previous row because after that nothing is placed
            if (path[i][c] == 1) {
                return false;
            }
        }

        // Check right top diagonal
        int cr = r - 1;
        int cc = c + 1;

        while (cr >= 0 && cc < n) {
            if (path[cr][cc] == 1) {
                return false;
            }
            cr--;
            cc++;
        }

        // Check left top diagonal
        cr = r - 1;
        cc = c - 1;
        while (cr >= 0 && cc >= 0) {
            if (path[cr][cc] == 1) {
                return false;
            }
            cr--;
            cc--;
        }

        return true;
    }

    private static void print(int n, int[][] path) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
