package com.demo.dp;

public class MinCostPath {

    public static void main(String[] args) {
        System.out.println(minCostPath(new int[][]{
                {1, 5, 11},
                {8, 13, 12},
                {2, 3, 7}
        }));
    }

    public static int minCostPath(int[][] input) {
        int m = input.length - 1;
        int n = input[0].length - 1;

        return cost(input, 0, 0, m, n);
    }

    private static int cost(int[][] arr, int r, int c, int m, int n) {
        if (r == m && c == n) {
            return arr[m][n];
        } else if (r > m || c > m) {
            return Integer.MAX_VALUE;
        }
        int rc = cost(arr, r, c + 1, m, n);
        int bc = cost(arr, r + 1, c, m, n);
        int dc = cost(arr, r + 1, c + 1, m, n);
        return arr[r][c] + Math.min(rc, Math.min(bc, dc));
    }
}