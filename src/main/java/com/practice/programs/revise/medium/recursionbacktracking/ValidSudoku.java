package com.practice.programs.revise.medium.recursionbacktracking;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TC: O(n^2), AS: O(n^2), where n = 9
 */
@Slf4j
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'} // 1
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        log.info("{}", validSudoku(board));  // true

    }

    public static boolean validSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Map<Integer, Set<Character>> quadrantMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            rowSet.clear();
            colSet.clear();
            if (i % 3 == 0) { // different quadrant
                quadrantMap.clear();
            }
            for (int j = 0; j < board.length; j++) {
                char rowCh = board[i][j];
                if (rowCh != '.' && !rowSet.add(rowCh)) { // add row
                    return false;
                }
                char colCh = board[j][i];
                if (colCh != '.' && !colSet.add(colCh)) { // add col
                    return false;
                }
                int quadrantIdx = j / 3;
                char quadrantCh = board[i][j]; // add to quadrant
                quadrantMap.putIfAbsent(quadrantIdx, new HashSet<>());
                if (quadrantCh != '.' && !quadrantMap.get(quadrantIdx).add(quadrantCh)) {
                    return false;
                }
            }
        }
        return true;
    }
}
