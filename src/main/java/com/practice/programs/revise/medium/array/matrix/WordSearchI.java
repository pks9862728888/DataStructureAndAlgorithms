package com.practice.programs.revise.medium.array.matrix;

/**
 * https://leetcode.com/problems/word-search/
 * Concepts:
 * MATRIX
 */
public class WordSearchI {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int nRows = board.length;
        int nCols = nRows > 0 ? board[0].length : 0;
        boolean[][] visited = new boolean[nRows][nCols];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if (board[r][c] == word.charAt(0) &&
                        exist(board, word, r, c, 0, nRows, nCols, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int r, int c, int idx, int nRows,
                          int nCols, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (board[r][c] != word.charAt(idx)) {
            return false;
        }
        visited[r][c] = true;
        for (int[] dir: dirs) {
            int rr = r + dir[0];
            int cc = c + dir[1];
            if (isValid(rr, cc, nRows, nCols, visited) &&
                    exist(board, word, rr, cc, idx + 1, nRows, nCols, visited)) {
                return true;
            }
        }
        visited[r][c] = false;
        return idx + 1 == word.length();
    }

    private boolean isValid(int r, int c, int nRows, int nCols, boolean[][] visited) {
        return r >= 0 && r < nRows && c >= 0 && c < nCols && !visited[r][c];
    }
}
