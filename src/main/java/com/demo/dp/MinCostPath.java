package com.demo.dp;

import java.util.Arrays;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 5, 11},
                {8, 13, 12},
                {2, 3, 7}
        };

        System.out.println(minCostPath(arr));
    }

    public static int minCostPath(int[][] arr) {
        int m = arr.length - 1;
        int n = arr[0].length - 1;
        int[][] dp = new int[arr.length][arr[0].length];
        fill(dp, -1);
        return cost(arr, 0, 0, m, n, dp);
    }

    private static int cost(int[][] arr, int r, int c, int m, int n, int[][] dp) {
        if (r == m && c == n) {
            return arr[m][n];
        } else if (r > m || c > m) {
            return Integer.MAX_VALUE;
        } else if (dp[r][c] != -1) {
            return dp[r][c];
        }

        // Calculate min cost
        int rc = cost(arr, r, c + 1, m, n, dp);
        int bc = cost(arr, r + 1, c, m, n, dp);
        int dc = cost(arr, r + 1, c + 1, m, n, dp);
        int minCost =  arr[r][c] + Math.min(rc, Math.min(bc, dc));

        // Memoization
        dp[r][c] = minCost;

        return minCost;
    }

    private static void fill(int[][] dp, int value) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], value);
        }
    }
}