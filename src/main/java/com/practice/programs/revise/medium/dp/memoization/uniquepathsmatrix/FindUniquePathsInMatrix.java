package com.practice.programs.revise.medium.dp.memoization.uniquepathsmatrix;

public class FindUniquePathsInMatrix {

    private static final int[][] dirs = {{0, 1}, {1, 0}};
    private static int MOD = 1000000007;

    /**
     * Find unique paths to reach from (m, n) to (1, 1)
     * if m = 3, and n = 2, then unique paths = 3
     * Memo:
     * TC: O(m * n), AS: 2 O(m * n) + call stack
     * Tabulation
     * TC: O(m * n), AS: O(m * n)
     * Concepts:
     * MEMOIZATION
     * TABULATION
     * FIND_UNIQUE_PATHS_DP
     */
    public int uniquePaths(int m, int n) {
        // boolean[][] visited = new boolean[m + 1][n + 1];
        // long[][] cache = new long[m + 1][n + 1];
        // for (long[] row: cache) Arrays.fill(row, -1);
        // return (int) findUniqueMemoization(m, n, visited, cache);
        return findUniqueTabulation(m, n);
    }

    private int findUniqueTabulation(int m, int n) {
        long[][] dp = new long[m][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) { // Base case
                    dp[i][j] = 1;
                } else { // All possibilities
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }

    private long findUniqueMemoization(int m, int n, boolean[][] visited, long[][] cache) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (cache[m][n] == -1) {
            visited[m][n] = true;
            long ways = 0;
            for (int[] outcome: dirs) {
                int mm = m - outcome[0];
                int nn = n - outcome[1];
                if (mm > 0 && nn > 0 && !visited[mm][nn]) {
                    ways = (ways + findUniqueMemoization(mm, nn, visited, cache)) % MOD;
                }
            }
            visited[m][n] = false;
            cache[m][n] = ways;
        }
        return cache[m][n];
    }
}
