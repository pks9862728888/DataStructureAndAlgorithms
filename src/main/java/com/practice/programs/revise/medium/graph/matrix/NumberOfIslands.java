package com.practice.programs.revise.medium.graph.matrix;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Concepts:
 * GRAPH
 * 2D_GRAPH
 */
public class NumberOfIslands {

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j, m, n);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void visit(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int[] d: dir) {
            visit(grid, x + d[0], y + d[1], m, n);
        }
    }
}
