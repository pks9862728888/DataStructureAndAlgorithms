package com.practice.programs.backtracking;

import com.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;

public class RatMazePrintAllPossiblePath implements Printer {

    private static final int TARGET_X = 2;
    private static final int TARGET_Y = 2;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
        System.out.println(findAllPaths(m));
    }

    public static ArrayList<String> findAllPaths(ArrayList<ArrayList<Integer>> m) {
        ArrayList<String> paths = new ArrayList<>();
        findPaths(m, 0, 0, m.size(), paths, new ArrayList<>(), "");
        return paths;
    }
    private static void findPaths(
            ArrayList<ArrayList<Integer>> m, int sx, int sy, int n,
            ArrayList<String> paths, ArrayList<Integer[]> tp, String cp) {
        if (sx == TARGET_X && sy == TARGET_Y && m.get(sx).get(sy) == 1) {
            paths.add(cp);
            return;
        }
        if (isValid(m, sx, sy, n, tp)) {
            Integer[] ob = {sx, sy};
            tp.add(ob);
            findPaths(m, sx + 1, sy, n, paths, tp, cp + "D");
            findPaths(m, sx, sy + 1, n, paths, tp, cp + "R");
            findPaths(m, sx, sy - 1, n, paths, tp, cp + "L");
            findPaths(m, sx - 1, sy, n, paths, tp, cp + "U");
            tp.remove(ob);
        }
    }
    private static boolean isValid(ArrayList<ArrayList<Integer>> m, int sx, int sy, int n, ArrayList<Integer[]> tp) {
        if (sx < 0 || sy < 0 || sx == n || sy == n || m.get(sx).get(sy) == 0) {
            return false;
        }
        for (Integer[] nd: tp) {
            if (nd[0] == sx && nd[1] == sy) {
                return false;
            }
        }
        return true;
    }
}
