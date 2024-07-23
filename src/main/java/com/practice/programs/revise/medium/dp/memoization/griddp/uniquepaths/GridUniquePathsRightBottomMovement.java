package com.practice.programs.revise.medium.dp.memoization.griddp.uniquepaths;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 * TC: O(m * n), AS: O(m * n)
 * Concepts:
 * DP
 * UNIQUE_PATH_GRID_DP
 * MEMOIZATION
 */
public class GridUniquePathsRightBottomMovement {

    private static final int[][] dir = {{1, 0}, {0, 1}};

    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[][] cache = new int[m][n];
        for(int[] row: cache) Arrays.fill(row, -1);
        return find(0, 0, m - 1, n - 1, visited, cache);
    }

    private int find(int x, int y, int m, int n, boolean[][] visited, int[][] cache) {
        if (x == m && y == n) {
            return 1;
        }
        if (cache[x][y] == -1) {
            visited[x][y] = true;
            int uniquePaths = 0;
            for (int[] d: dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                if (canVisit(xx, yy, m, n, visited)) {
                    uniquePaths += find(xx, yy, m, n, visited, cache);
                }
            }
            visited[x][y] = false;
            cache[x][y] = uniquePaths;
        }
        return cache[x][y];
    }

    private static boolean canVisit(int x, int y, int m, int n, boolean[][] visited) {
        return x >= 0 && y >= 0 && x <= m && y <= n && !visited[x][y];
    }
}
