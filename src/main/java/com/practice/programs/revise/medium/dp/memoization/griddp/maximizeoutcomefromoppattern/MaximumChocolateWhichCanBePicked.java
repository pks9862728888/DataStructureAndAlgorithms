package com.practice.programs.revise.medium.dp.memoization.griddp.maximizeoutcomefromoppattern;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup
 * TC: O(n * m * n)
 * AS: O(n * m * m)
 * Maximize chocolates which can be picked by two robots located at (0, 0), (0, m - 1)
 * If two robots point to same position, then only one of then can pick
 * Robots can move top to bottom, bottom left, bottom right
 * Concepts:
 * DP
 * MEMOIZATION
 * MULTI_SOURCE_OUTCOME_MAXIMIZATION
 */
public class MaximumChocolateWhichCanBePicked {

    public int solve(int n, int m, int grid[][]) {
        Map<String, Integer> cache = new HashMap<>();
        return find(grid, 0, 0, m - 1, n, m, cache);
    }


    private int find(int[][] grid, int x, int y1, int y2, int n, int m,
                     Map<String, Integer> cache) {
        if (x == n - 1) {
            return y1 == y2 ? grid[x][y1] : grid[x][y1] + grid[x][y2];
        }
        String key = x + "#" + y1 + "#" + y2;
        if (!cache.containsKey(key)) {
            int max = 0;
            for (int dj1 = -1; dj1 <= 1; dj1++) {
                for (int dj2 = -1; dj2 <= 1; dj2++) {
                    int y1y = y1 + dj1;
                    int y2y = y2 + dj2;
                    if (y1y >= 0 && y2y >= 0 && y1y < m && y2y < m) {
                        int val = y1 == y2 ? grid[x][y1] : (grid[x][y1] + grid[x][y2]);
                        val += find(grid, x + 1, y1y, y2y, n, m, cache);
                        max = Math.max(max, val);
                    }
                }
            }
            cache.put(key, max);
        }
        return cache.get(key);
    }
}
