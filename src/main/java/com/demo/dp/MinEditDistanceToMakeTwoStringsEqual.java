package com.demo.dp;

import java.util.Arrays;

public class MinEditDistanceToMakeTwoStringsEqual {

    /**
     * Edit Distance of two strings is the minimum number of steps required to make
     * one string equal to the other.
     * In order to do so, you can perform the following three operations:
     * 1. Delete a character
     * 2. Replace a character with another one
     * 3. Insert a character
     */
    public static void main(String[] args) {
        System.out.println(editDistanceRecursively("abc", "dc"));
        System.out.println(editDistanceRecursively("whgtdwhgtdg","aswcfg"));

        System.out.println(editDistanceIteratively("abc", "dc"));
        System.out.println(editDistanceIteratively("whgtdwhgtdg","aswcfg"));
    }

    public static int editDistanceIteratively(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                memo[i][j] = dist(s, t, i, j, memo);
            }
        }

        return memo[0][0];
    }

    public static int editDistanceRecursively(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return dist(s, t, 0, 0, memo);
    }

    private static int dist(String s, String t, int i, int j, int[][] memo) {
        if (i == s.length() && j == t.length()) { // Both exceeded, i.e. string is equal
            return 0;
        } else if (i == s.length()) { // Only 1 length exceeded
            return t.length() - j;
        } else if (j == t.length()) {
            return s.length() - i;
        } else if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dist(s, t, i + 1, j + 1, memo);
        } else {
            int del = dist(s, t, i + 1, j, memo);
            int repl = dist(s, t, i + 1, j + 1, memo);
            int insert = dist(s, t, i, j + 1, memo);
            int res = 1 + Math.min(del, Math.min(repl, insert));
            memo[i][j] = res;
            return res;
        }
    }

}