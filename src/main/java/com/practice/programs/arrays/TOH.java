package com.practice.programs.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Platform: GFG, Coding Ninjas
 * Question: Move disk from 1 -> 3 tower given:
 * Order of moving should be same (i.e bigger disk should always in bottom)
 */
public class TOH {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3));
    }
    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int n) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        toh(n, 1, 2, 3, l);
        return l;
    }
    private static void toh(int n, int a, int b, int c, ArrayList<ArrayList<Integer>> l) {
        if (n == 1) {
            l.add(new ArrayList<>(Arrays.asList(a, c)));
            return;
        }
        toh(n - 1, a, c, b, l);
        l.add(new ArrayList<>(Arrays.asList(a, c)));
        toh(n - 1, b, a, c, l);
    }
}
