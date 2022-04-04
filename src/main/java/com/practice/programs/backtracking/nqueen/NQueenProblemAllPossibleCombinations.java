package com.practice.programs.backtracking.nqueen;

import com.utils.Printer;

import java.util.ArrayList;

public class NQueenProblemAllPossibleCombinations implements Printer {

    public static void main(String[] args) {
//        placeNQueen(3);
        placeNQueen(4);
    }

    private static boolean placeNQueen(int n) {
        int[][] placement = new int[n][n];
        ArrayList<ArrayList<Integer>> placements = new ArrayList<>();
        if (placeNQueen(placements, placement, 0, n)) {
            Printer.printMatrixes(placements, n);
            return true;
        } else {
            System.out.println("Placement not possible");
            return false;
        }
    }

    private static boolean placeNQueen(ArrayList<ArrayList<Integer>> placements, int[][] m, int colIdx, int n) {
        if (colIdx >= n) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    al.add(m[i][j]);
                }
            }
            placements.add(al);
            return true;
        }
        boolean placed = false;
        for (int i = 0; i < n; i++) {  // row
            if (isSafeToPlaceQueen(m, i, colIdx, n)) {
                int[][] nm = getCopy(m, n);
                nm[i][colIdx] = 1;
                if (placeNQueen(placements, nm, colIdx + 1, n)) {
                    placed = true;
                } else {
                    nm[i][colIdx] = 0;
                }
            }
        }
        return placed;
    }

    private static int[][] getCopy(int[][] m, int n) {
        int[][] nm = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nm[i][j] = m[i][j];
            }
        }
        return nm;
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
