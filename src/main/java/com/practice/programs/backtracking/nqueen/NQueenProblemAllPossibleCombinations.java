package com.practice.programs.backtracking.nqueen;

import com.utils.Printer;

import java.util.ArrayList;

/**
 * Optimized solution
 * Source: Coding Ninja
 */
public class NQueenProblemAllPossibleCombinations implements Printer {

    public static void main(String[] args) {
//        placeNQueen(3);
        Printer.printMatrixes(nQueens(4), 4);
    }

    public static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> queensInRows = new ArrayList<>();
        ArrayList<Integer> queensInDiag1 = new ArrayList<>();
        ArrayList<Integer> queensInDiag2 = new ArrayList<>();
        addToList(queensInRows, n, -1);
        addToList(queensInDiag1, 2 * n, -1);
        addToList(queensInDiag2, 2 * n, -1);
        nQueensHelper(0, n, ans, queensInRows, queensInDiag1, queensInDiag2);

        return ans;
    }

    public static void nQueensHelper(int col, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> qr,
                                     ArrayList<Integer> qd1, ArrayList<Integer> qd2) {
        // If all the queens have been placed
        if (col == n) {
            addSolution(n, ans, qr);
            return;
        }

        // Try all the rows for column col
        for (int row = 0; row < n; row++) {
            // If it's not safe to place queen here
            if ((qr.get(row) != -1) || (qd1.get(col - row + n - 1) != -1) || (qd2.get(col + row) != -1)) {
                continue;
            }

            // Mark queen placed
            qr.set(row, col);
            qd1.set(col - row + n - 1, col);
            qd2.set(col + row, col);

            // Try placing the remaining queens
            nQueensHelper(col + 1, n, ans, qr, qd1, qd2);

            // Un-mark the cell to backtrack
            qr.set(row, -1);
            qd1.set(col - row + n - 1, -1);
            qd2.set(col + row, -1);
        }
    }

    public static void addSolution(int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> queensInRows) {
        ArrayList<Integer> currentAnswer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (queensInRows.get(j) == i) {
                    currentAnswer.add(1);
                } else {
                    currentAnswer.add(0);
                }
            }
        }

        ans.add(currentAnswer);
    }

    private static void addToList(ArrayList<Integer> al, int n, int value) {
        for (int i = 0; i < n; i++) {
            al.add(value);
        }
    }
}
