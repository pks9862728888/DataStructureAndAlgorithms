package com.practice.programs.revise.medium.dp.memoization.griddp.uniquepaths;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * Cells have 0 or 1, only if its 0 then you can move in a cell
 * Find unique paths to move from [0, 0] to [m - 1][n - 1]
 * TC: O (m * n), AS: O(m * n)
 * Concepts:
 * DP
 * MEMOIZATION
 * FIND_UNIQUE_PATHS_DP
 * Edge cases:
 * When m, n has value 1 then can't move
 * When 0, 0 itself has value 1, then cant move
 */
public class GridUniquePathIIWithObstacle {

    private static final int[][] dir = {{1, 0}, {0, 1}};

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length - 1;
        int n = m >= 0 ? grid[0].length - 1 : 0;
        int[][] cache = new int[m + 1][n + 1];
        for (int[] row: cache) Arrays.fill(row, -1);
        return findUnique(grid, 0, 0, m, n, cache);
    }

    public int findUnique(int[][] grid, int x, int y, int m, int n, int[][] cache) {
        if (x == m && y == n) {
            return grid[x][y] == 0 ? 1 : 0;
        } else if (grid[x][y] != 0) {
            return 0;
        }
        if (cache[x][y] == -1) {
            grid[x][y] = 2;
            int ways = 0;
            for (int[] d: dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                if (canVisit(grid, xx, yy, m, n)) {
                    ways += findUnique(grid, xx, yy, m, n, cache);
                }
            }
            grid[x][y] = 0;
            cache[x][y] = ways;
        }
        return cache[x][y];
    }

    private boolean canVisit(int[][] grid, int xx, int yy, int m, int n) {
        return xx <= m && yy <= n && grid[xx][yy] == 0;
    }
}
