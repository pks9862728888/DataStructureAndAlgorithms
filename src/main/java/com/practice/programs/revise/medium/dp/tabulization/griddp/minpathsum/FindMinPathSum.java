package com.practice.programs.revise.medium.dp.tabulization.griddp.minpathsum;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * TC: O(m * n), AS: O(1)
 * If only you can move towards right and bottom, find min path sum
 * Concepts:
 * DP
 * TABULATION
 * GRID_MIN_PATH_SUM_OR_MAX_PATH_SUM
 */
public class FindMinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) { // first row (can only get from left)
                    grid[i][j] += get(grid, i, j - 1);
                } else if (j == 0) { // first col (can only get from top)
                    grid[i][j] += get(grid, i - 1, j);
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return m > 0 && n > 0 ? grid[m - 1][n - 1] : 0;
    }

    private static int get(int[][] grid, int x, int y) {
        return x < 0 || y < 0 ? 0 : grid[x][y];
    }
}
