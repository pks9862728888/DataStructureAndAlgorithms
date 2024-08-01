package com.practice.programs.revise.medium.graph.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Concepts:
 * GRAPH
 * 2D_GRAPH
 */
public class PacificAtlanticWaterFlow {
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = m > 0 ? heights[0].length : 0;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // Traverse top and bottom most row
        for (int j = 0; j < n; j++) {
            mark(0, j, Integer.MIN_VALUE, heights, pacific, m, n);
            mark(m - 1, j, Integer.MIN_VALUE, heights, atlantic, m, n);
        }
        // Traverse left and right most column
        for (int i = 0; i < m; i++) {
            mark(i, 0, Integer.MIN_VALUE, heights, pacific, m, n);
            mark(i, n - 1, Integer.MIN_VALUE, heights, atlantic, m, n);
        }
        // Prepare result
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void mark(int i, int j, int prev, int[][] heights, boolean[][] ocean, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || ocean[i][j] || heights[i][j] < prev) {
            return;
        }
        ocean[i][j] = true;
        for (int[] d: dir) {
            mark(i + d[0], j + d[1], heights[i][j], heights, ocean, m, n);
        }
    }
}
