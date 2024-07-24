package com.practice.programs.revise.medium.dp.tabulization.griddp.minpathsum;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * You can move either vertically down or diagonally down
 * Concepts:
 * DP
 * TABULATION
 * GRID_MIN_PATH_SUM_OR_MAX_PATH_SUM
 */
public class MinPathSumTriangularDp {

    public int minimumTotal(List<List<Integer>> triangle) {
        int minSum = Integer.MAX_VALUE;
        int m = triangle.size();
        for (int i = 0; i < m; i++) {
            int n = triangle.get(i).size();
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < n; j++) {
                int currMinSum;
                if (j == 0) { // first col (can only get from prev row same col)
                    currMinSum = currRow.get(j) + get(triangle, i - 1, j);
                } else if (j == n - 1) { // edge row (can only get from prev row, prev col)
                    currMinSum = currRow.get(j) + get(triangle, i - 1, j - 1);
                } else {
                    currMinSum = currRow.get(j) + Math.min(get(triangle, i - 1, j), get(triangle, i - 1, j - 1));
                }
                currRow.set(j, currMinSum);
                if (i == m - 1) {
                    minSum = Math.min(minSum, currMinSum);
                }
            }
        }
        return minSum;
    }

    private int get(List<List<Integer>> triangle, int x, int y) {
        return x < 0 || y < 0 || y >= triangle.get(x).size() ? 0 : triangle.get(x).get(y);
    }
}
