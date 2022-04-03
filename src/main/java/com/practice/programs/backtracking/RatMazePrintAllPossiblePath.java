package com.practice.programs.backtracking;

import com.utils.Printer;

import java.util.ArrayList;

public class RatMazePrintAllPossiblePath implements Printer {

    public static void main(String[] args) {
        int[][] m = {
                {1, 1},
                {1, 1}
        };
        int n = m.length;
        System.out.println(findAllPossiblePaths(m, n));
    }

    private static ArrayList<String> findAllPossiblePaths(int[][] m, int n) {
        ArrayList<String> paths = new ArrayList<>();
        findAllPaths(m, 0, 0, n, paths, new ArrayList<>(), "");
        return paths;
    }

    /**
     * D for down
     * R for right
     * L for left
     * U for up
     */
    private static void findAllPaths(int[][] m, int sx, int sy, int n, ArrayList<String> paths, ArrayList<Integer[]> tp, String cp) {
        if (sx == n - 1 && sy == n - 1 && m[sx][sy] == 1) {
            paths.add(cp);
            return;
        }
        if (isValid(m, sx, sy, n, tp)) {
            tp.add(new Integer[] {sx, sy});
            findAllPaths(m, sx + 1, sy, n, paths, copyAsNew(tp), cp + "D"); // DOWN
            findAllPaths(m, sx, sy + 1, n, paths, copyAsNew(tp), cp + "R"); // RIGHT
            findAllPaths(m, sx, sy - 1, n, paths, copyAsNew(tp), cp + "L"); // LEFT
            findAllPaths(m, sx - 1, sy, n, paths, copyAsNew(tp), cp + "U"); // UP
        }
    }

    private static ArrayList<Integer[]> copyAsNew(ArrayList<Integer[]> tp) {
        ArrayList<Integer[]> al = new ArrayList<>();
        for (Integer[] n: tp) {
            al.add(new Integer[] {n[0], n[1]});
        }
        return al;
    }

    private static boolean isValid(int[][] m, int sx, int sy, int n, ArrayList<Integer[]> tp) {
        if (sx < 0 || sy < 0 || sx == n || sy == n || m[sx][sy] == 0) {
            return false;
        }
        for (Integer[] node: tp) {
            if (node[0] == sx && node[1] == sy) {
                return false;
            }
        }
        return true;
    }
}
