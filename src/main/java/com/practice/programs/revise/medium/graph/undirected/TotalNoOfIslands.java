package com.practice.programs.revise.medium.graph.undirected;

/**
 * TC: O(m * n), AS: O(m * n)
 */
public class TotalNoOfIslands {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int visitedCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visitedCount++;
                    visit(grid, i, j, n, m, visited);
                }
            }
        }
        return visitedCount;
    }

    private void visit(char[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        visited[i][j] = true;
        for (int dir = 0; dir < dx.length; dir++) {
            int x = i + dx[dir];
            int y = j + dy[dir];
            if (canVisit(grid, x, y, n, m, visited)) {
                visit(grid, x, y, n, m, visited);
            }
        }
    }

    private boolean canVisit(char[][] grid, int x, int y, int n, int m, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] == '1';
    }
}
