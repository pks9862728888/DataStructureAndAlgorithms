package com.practice.programs.revise.medium.recursionbacktracking;

/**
 * TC: O(m * n * 4 ^ (length of word))
 * AS: O(m * n + length of word)
 */
class FindWords {

    int[][] moves = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length  == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    if (find(board, word, x, y, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int x, int y, int idx, boolean[][] visited) {
        if (idx + 1 == word.length()) {
            return board[x][y] == word.charAt(idx);
        } else if (board[x][y] != word.charAt(idx)) {
            return false;
        }
        visited[x][y] = true;
        for(int[] move: moves) {
            int nx = x + move[0];
            int ny = y + move[1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny]) {
                if (find(board, word, nx, ny, idx + 1, visited)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}
