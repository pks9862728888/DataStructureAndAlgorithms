package com.demo.dp;

public class MagicGrid {

    /**
     * You are given a magic grid A with R rows and C columns.
     * In the cells of the grid, you will either get magic juice,
     * which increases your strength by |A[i][j]| points, or poison,
     * which takes away |A[i][j]| strength points.
     * If at any point of the journey, the strength points become less than or equal to zero,
     * then you will die.
     * You have to start from the top-left corner cell (1,1)
     * and reach at the bottom-right corner cell (R,C).
     * From a cell (i,j), you can only move either one cell down or right i.e.,
     * to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid.
     * You have to find the minimum number of strength points with which you will
     * be able to reach the destination cell.
     */
    public static void main(String[] args) {
        // Ans: 2
        System.out.println(getMinimumStrength(new int[][] {
                {0, -2, -3, 1},
                {-1, 4, 0, -2},
                {1, -2, -3, 0}
        }));
    }

    /**
     * Logic is: f(i, j, memo) = Math.min(f(i+1, j, memo), f(i, j + 1, memo))
     */
    public static int getMinimumStrength(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                memo[i][j] = Math.min(get(i + 1, j, memo), get(i, j + 1, memo));
                memo[i][j] = memo[i][j] == Integer.MAX_VALUE ? 1 : (memo[i][j] - grid[i][j]);
                if (memo[i][j] < 0) {
                    memo[i][j] = 1;
                }
            }
        }

        return memo[0][0] > 0 ? memo[0][0] : (-memo[0][0] + 1);
    }

    private static int get(int i, int j, int[][] memo) {
        if (i >= memo.length || j >= memo[0].length) {
            return Integer.MAX_VALUE;
        }
        return memo[i][j];
    }
}