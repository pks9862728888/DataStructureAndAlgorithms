package com.practice.programs.backtracking.nqueen;

import com.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Optimized solution
 * Source: Coding Ninja
 */
public class NQueenProblemAllPossibleCombinations implements Printer {

    public static void main(String[] args) {
//        placeNQueen(3);
        placeNQueen(4);
    }

    private static boolean placeNQueen(int n) {
        int[] rowP = new int[n];
        int[] diag1 = new int[2 * n];
        int[] diag2 = new int[2 * n];
        Arrays.fill(rowP, -1);
        Arrays.fill(diag1, -1);
        Arrays.fill(diag2, -1);
        ArrayList<ArrayList<Integer>> placements = new ArrayList<>();
        if (placeNQueen(placements, rowP, diag1, diag2, 0, n)) {
            Printer.printMatrixes(placements, n);
            return true;
        } else {
            System.out.println("Placement not possible");
            return false;
        }
    }

    private static boolean placeNQueen(ArrayList<ArrayList<Integer>> placements, int[] rp, int[] dp1, int[] dp2, int colIdx, int n) {
        if (colIdx >= n) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) { // i = row, rp[i] contains colIdx
                for (int j = 0; j < n; j++) {
                    if (j == rp[i]) {
                        al.add(1);
                    } else {
                        al.add(0);
                    }
                }
            }
            placements.add(al);
            return true;
        }
        boolean placed = false;
        for (int i = 0; i < n; i++) {  // row
            if (isSafeToPlaceQueen(rp, dp1, dp2, i, colIdx, n)) {
                int[] rpCopy = Arrays.copyOf(rp, rp.length);
                int[] dp1Copy = Arrays.copyOf(dp1, dp1.length);
                int[] dp2Copy = Arrays.copyOf(dp2, dp2.length);
                rpCopy[i] = colIdx;
                dp1Copy[i + colIdx] = colIdx;
                dp2Copy[colIdx - i + n - 1] = colIdx;
                if (placeNQueen(placements, rpCopy, dp1Copy, dp2Copy, colIdx + 1, n)) {
                    placed = true;
                } else {
                    rpCopy[i] = -1;
                    dp1Copy[i + colIdx] = -1;
                    dp2Copy[colIdx - i + n - 1] = -1;
                }
            }
        }
        return placed;
    }

    private static boolean isSafeToPlaceQueen(int[] rp, int[] dp1, int[] dp2, int rowIdx, int colIdx, int n) {
        if (rp[rowIdx] != -1) { // check whether row contains queen
            return false;
        }
        for (int i = 0; i < n; i++) {  // check whether column contains queen
            if (rp[i] == colIdx) {
                return false;
            }
        }

        // upper left diagonal
        if (dp1[rowIdx + colIdx] != -1) {
            return false;
        }

        // lower left diagonal
        return dp2[colIdx - rowIdx + n - 1] == -1;
    }
}
