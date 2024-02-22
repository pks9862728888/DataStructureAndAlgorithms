package com.practice.programs.revise.medium.dp.tabulization;

class FindMinPathSum {

    // Optimized (tabulation) - you can move only right and bottom
    // TC: O(m * n), AS: O(m * n)
    static int minimumPathSumTabulation(int[][] grid) {
        if (grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] minPathSum = new int[n][m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int topCost = findCost(minPathSum, x - 1, y);
                int leftCost = findCost(minPathSum, x, y - 1);
                int minCost = (x == 0 && y == 0) ? grid[x][y] :
                        grid[x][y] + Math.min(topCost, leftCost);
                minPathSum[x][y] = minCost;
            }
        }
        return minPathSum[n - 1][m - 1];
    }

    private static int findCost(int[][] minPathSum, int x, int y) {
        return (x < 0 || y < 0) ? Integer.MAX_VALUE : minPathSum[x][y];
    }

     private static final int[][] moves = {{1, 0}, {0, 1}};

     static int minimumPathSumDp(int[][] grid) {
         if (grid.length == 0) return 0;
         int n = grid.length;
         int m = grid[0].length;
         return findMinPathSum(grid, 0, 0, n - 1, m - 1);
     }

     private static int findMinPathSum(int[][] grid, int x, int y, int n, int m) {
         int minSum = Integer.MAX_VALUE;
         for (int[] move: moves) {
             int xx = x + move[0];
             int yy = y + move[1];
             if (canMove(xx, yy, n, m)) {
                 minSum = Math.min(minSum, findMinPathSum(grid, xx, yy, n, m));
             }
         }
         return grid[x][y] + (minSum == Integer.MAX_VALUE ? 0 : minSum);
     }

     private static boolean canMove(int x, int y, int n, int m) {
         return x <= n && y <= m;
     }
}
