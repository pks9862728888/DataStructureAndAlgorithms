package com.practice.programs.backtracking;

import com.utils.Printer;

import java.util.ArrayList;

public class RatMaze implements Printer {

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 0, 0, 1}};
        int n = m.length;
        int[][] path = new int[n][n];
        if (canReach(m, n, 0, 0, n - 1, n - 1, path)) {
            Printer.printMatrix(path);
        } else {
            System.out.println("Can't reach");
        }
    }

    public static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, int[][] p) {
        p[sr][sc] = 1;
        return canReach(m, n, sr, sc, n - 1, n - 1, p, new ArrayList<>());
    }

    public static boolean canReach(int[][] m, int n, int sr, int sc, int yr, int yc, int[][] path, ArrayList<Integer[]> tn) {
        if (sr == yr && sc == yc) {
            return true;
        } else if (sr > yr && sc > yc) {
            return false;
        }
        boolean reached = false;
        if (isValid(m, sr + 1, sc, n, tn)) { // DOWN
            tn.add(new Integer[]{sr + 1, sc});
            reached = canReach(m, n, sr + 1, sc, yr, yc, path, tn);
            setPathIfReached(path, sr + 1, sc, reached);
        }
        if (!reached && isValid(m, sr, sc + 1, n, tn)) { // RIGHT
            tn.add(new Integer[]{sr, sc + 1});
            reached = canReach(m, n, sr, sc + 1, yr, yc, path, tn);
            setPathIfReached(path, sr, sc + 1, reached);
        }
        if (!reached && isValid(m, sr, sc - 1, n, tn)) { // LEFT
            tn.add(new Integer[]{sr, sc - 1});
            reached = canReach(m, n, sr, sc - 1, yr, yc, path, tn);
            setPathIfReached(path, sr, sc - 1, reached);
        }
        if (!reached && isValid(m, sr - 1, sc, n, tn)) { // UP
            tn.add(new Integer[]{sr - 1, sc});
            reached = canReach(m, n, sr - 1, sc, yr, yc, path, tn);
            setPathIfReached(path, sr - 1, sc, reached);
        }
        return reached;
    }

    private static void setPathIfReached(int[][] path, int sr, int sc, boolean reached) {
        if (reached) {
            path[sr][sc] = 1;
        }
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
