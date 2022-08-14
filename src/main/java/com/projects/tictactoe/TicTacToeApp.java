package com.projects.tictactoe;

import java.util.Optional;

import static com.projects.tictactoe.PrintUtils.printSpecialLine;

class TicTacToeApp {

    public static void main(String[] args) {
        GameManager ob = new GameManager();
        ob.initGame();
        Optional<Player> winner = ob.play();
        printWinner(winner);
    }

    private static void printWinner(Optional<Player> winner) {
        if (winner.isEmpty()) {
            printSpecialLine("Tough Fight! Game Result: DRAW!");
        } else {
            printSpecialLine(String.format("%s won the game!", winner.get().getName()));
        }
    }
}
