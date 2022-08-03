package com.demo.dp;

import java.util.Arrays;

public class MinCostPath {

    /**
     * BOTTOM UP APPROACH IS USED
     */
    private static final Integer DP_EMPTY_VALUE = null;

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 5, 11},
                {8, 13, 12},
                {2, 3, 7}
        };

        System.out.println(minCostPath(arr));
        System.out.println(minCostPathIteratively(arr));
    }

    public static int minCostPathIteratively(int[][] arr) {
        int m = arr.length - 1;
        int n = arr[0].length - 1;
        Integer[][] dp = new Integer[arr.length][arr[0].length];
        fill(dp);

        // Min cost path iteratively
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                cost(arr, i, j, m, n, dp);
            }
        }

        return dp[0][0];
    }

    public static int minCostPath(int[][] arr) {
        int m = arr.length - 1;
        int n = arr[0].length - 1;
        Integer[][] dp = new Integer[arr.length][arr[0].length];
        fill(dp);
        return cost(arr, 0, 0, m, n, dp);
    }

    private static int cost(int[][] arr, int r, int c, int m, int n, Integer[][] dp) {
        if (r == m && c == n) {
            return arr[m][n];
        } else if (r > m || c > m) {
            return Integer.MAX_VALUE;
        } else if (dp[r][c] != DP_EMPTY_VALUE) {
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

    private static void fill(Integer[][] dp) {
        for (Integer[] integers : dp) {
            Arrays.fill(integers, DP_EMPTY_VALUE);
        }
    }
}