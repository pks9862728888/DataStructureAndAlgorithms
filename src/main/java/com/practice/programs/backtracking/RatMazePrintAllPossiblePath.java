package com.practice.programs.backtracking;

import com.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Optimal solution reached
 */
public class RatMazePrintAllPossiblePath implements Printer {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
//        m.add(new ArrayList<>(Arrays.asList(1, 1)));
//        m.add(new ArrayList<>(Arrays.asList(1, 1)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        System.out.println(findAllPaths(m, 2, 2));
    }

    public static ArrayList<String> findAllPaths(ArrayList<ArrayList<Integer>> m, int tx, int ty) {
        ArrayList<String> paths = new ArrayList<>();
        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();  // Optimal solution is to make a copy of matrix as visited
        for (ArrayList<Integer> rows: m) {
            visited.add(new ArrayList<>(rows));
        }
        findPaths(m, 0, 0, tx, ty, m.size(), paths, visited, "");
        return paths;
    }
    private static void findPaths(
            ArrayList<ArrayList<Integer>> m, int sx, int sy, int tx, int ty, int n,
            ArrayList<String> paths, ArrayList<ArrayList<Integer>> visited, String cp) {
        if (sx == tx && sy == ty && m.get(sx).get(sy) == 1) {
            paths.add(cp);
            return;
        }
        if (isValid(visited, sx, sy, n)) {
            visited.get(sx).set(sy, 0);
            findPaths(m, sx + 1, sy, tx, ty, n, paths, visited, cp + "D");
            findPaths(m, sx, sy + 1, tx, ty, n, paths, visited, cp + "R");
            findPaths(m, sx, sy - 1, tx, ty, n, paths, visited, cp + "L");
            findPaths(m, sx - 1, sy, tx, ty, n, paths, visited, cp + "U");
            visited.get(sx).set(sy, 1);
        }
    }
    private static boolean isValid(ArrayList<ArrayList<Integer>> visited, int sx, int sy, int n) {
        if (sx < 0 || sy < 0 || sx == n || sy == n || visited.get(sx).get(sy) == 0) {
            return false;
        }
        return true;
    }
}
