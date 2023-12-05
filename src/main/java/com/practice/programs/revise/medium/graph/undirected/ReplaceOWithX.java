package com.practice.programs.revise.medium.graph.undirected;

/**
 * TC: O(n * m), AS: O(n * m)
 * <a href="https://www.codingninjas.com/studio/problems/replace-%E2%80%98o%E2%80%99-with-%E2%80%98x%E2%80%99_630517?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class ReplaceOWithX {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void replaceOWithX(char matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        markAllNonIslandsVisited(matrix, n, m, visited);
        replaceOWithXForIsands(matrix, visited, n, m);
    }

    private static void replaceOWithXForIsands(
            char[][] matrix, boolean[][] visited, int n, int m) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!visited[i][j] && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }
    }

    private static void markAllNonIslandsVisited(
            char[][] matrix, int n, int m, boolean[][] visited) {
        // first row
        visitRow(0, n, m, matrix, visited);

        // last row
        if (n - 1 != 0) {
            visitRow(n - 1, n, m, matrix, visited);
        }

        // first column
        visitCol(0, n, m, matrix, visited);

        // last column
        if (m - 1 != 0) {
            visitCol(m - 1, n, m, matrix, visited);
        }
    }

    private static void visitRow(
            int r, int n, int m, char[][] matrix, boolean[][] visited) {
        for (int j = 0; j < m; j++) {
            if (!visited[r][j] && matrix[r][j] == 'O') {
                visit(r, j, n, m, matrix, visited);
            }
        }
    }

    private static void visitCol(
            int c, int n, int m, char[][] matrix, boolean[][] visited) {
        for (int j = 0; j < n; j++) {
            if (!visited[j][c] && matrix[j][c] == 'O') {
                visit(j, c, n, m, matrix, visited);
            }
        }
    }

    private static void visit(
            int i, int j, int n, int m, char[][] matrix, boolean[][] visited) {
        visited[i][j] = true;
        for (int dir = 0; dir < dx.length; dir++) {
            int ii = i + dx[dir];
            int jj = j + dy[dir];
            if (canVisit(ii, jj, n, m, visited, matrix)) {
                visit(ii, jj, n, m, matrix, visited);
            }
        }
    }

    private static boolean canVisit(
            int i, int j, int n, int m, boolean[][] visited, char[][] matrix) {
        return i >= 0 && j >= 0 && i < n && j < m && !visited[i][j] && matrix[i][j] == 'O';
    }
}
