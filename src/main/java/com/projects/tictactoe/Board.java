package com.projects.tictactoe;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

import static com.projects.tictactoe.MoveOutcome.*;

@Getter
@Setter
public class Board {

    private int boardSize;
    private char[][] board;
    private char EMPTY = ' ';
    private int totalCellsFilled;

    public Board() {
        this.boardSize = 3;
        this.board = new char[boardSize][boardSize];
        this.initEmptyBoard();
        this.totalCellsFilled = 0;
    }

    private void initEmptyBoard() {
        for (char[] b : board) {
            Arrays.fill(b, EMPTY);
        }
    }

    public void printBoard() {
        for (char[] r : board) {
            System.out.print("|");
            for (char c : r) {
                System.out.print(c + "|");
            }
            System.out.println();
        }
    }

    public MoveOutcome makeMoveAndEvaluateOutcome(int x, int y, Player currentPlayer, char player1Symbol) {
        // Validate move
        if (x < 0 || y < 0 || x >= boardSize || y >= boardSize || board[x][y] != EMPTY) {
            return INVALID_MOVE;
        }

        // Enter move
        board[x][y] = currentPlayer.getSymbol();
        this.totalCellsFilled++;

        // Evaluate outcome
        MoveOutcome outcome = CONTINUE;
        if (board[x][0] != EMPTY && board[x][0] == board[x][1] && board[x][1] == board[x][2] || // Column check
                board[0][y] != EMPTY && board[0][y] == board[1][y] && board[1][y] == board[2][y] || // Row check
                board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2] || // Right diagonal check
                board[2][0] != EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]    // Left diagonal check
        ) {
            outcome = currentPlayer.getSymbol() == player1Symbol ? PLAYER_1_WON : PLAYER_2_WON;
        } else if (totalCellsFilled == boardSize * boardSize) {
            outcome = DRAW;
        }

        return outcome;
    }
}
