package com.practice.programs.medium.backtracking.ratmaze;

import com.utils.Printer;

import java.util.ArrayList;

public class RatMazePrintPath implements Printer {

    public static void main(String[] args) {
//        int[][] m = {{1, 0, 0, 0},
//                {1, 1, 1, 1},
//                {1, 0, 1, 1},
//                {1, 0, 0, 1}};
        int[][] m = {
                {1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int n = m.length;
        int[][] path = new int[n][n];
        if (canReach(m, n, 0, 0, 2, 2, path)) {
            Printer.printMatrix(path);
        } else {
            Printer.printMatrix(path);
        }
    }

    private static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, int[][] p) {
        return canReach(m, n, sr, sc, yr, yc, p, new ArrayList<>());
    }

    private static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, int[][] path, ArrayList<Integer[]> tn) {
        if (sr == yr && sc == yc) {  // Destination is reached
            path[sr][sc] = 1;
            return true;
        } else if (isValid(m, sr, sc, n, tn)) {
            path[sr][sc] = 1;
            tn.add(new Integer[]{sr, sc});  // Keeps track of nodes already traversed

            if (canReach(m, n, sr + 1, sc, yr, yc, path, tn) // DOWN
                    || canReach(m, n, sr, sc + 1, yr, yc, path, tn) // RIGHT
                    || canReach(m, n, sr, sc - 1, yr, yc, path, tn) // LEFT
                    || canReach(m, n, sr - 1, sc, yr, yc, path, tn) // UP
            ) {
                return true;
            }

            path[sr][sc] = 0;
        }
        return false;
    }

    private static boolean isValid(int[][] m, int sr, int sc, int n, ArrayList<Integer[]> tn) {
        if (sr == n || sc == n) {
            return false;
        } else if (sr < 0 || sc < 0) {
            return false;
        } else if (m[sr][sc] == 1) {
            for (Integer[] arr : tn) {
                if (arr[0] == sr && arr[1] == sc) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
