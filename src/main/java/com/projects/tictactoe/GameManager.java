package com.projects.tictactoe;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import static com.projects.tictactoe.MoveOutcome.*;
import static com.projects.tictactoe.PrintUtils.printSeparator;
import static com.projects.tictactoe.PrintUtils.printSpecialLine;

public class GameManager {

    private Board board;
    private Player player1;
    private Player player2;
    private final char SYMBOL1 = 'X';
    private final char SYMBOL2 = 'O';
    private Player currentPlayer;
    private Player startingPlayer;
    private int round;
    private final int MIN_WIN_COUNT_TO_WIN_GAME = 3;
    private final int MAX_ROUNDS = 10;

    public void initGame() {
        printSpecialLine("WELCOME TO TIC TAC TOE GAME!");
        this.initPlayers();
        this.startingPlayer = player1;
        this.currentPlayer = startingPlayer;
        printInstructions();
    }

    public Optional<Player> play() {
        Scanner in = new Scanner(System.in);

        while (round != MAX_ROUNDS) {
            round++;
            printSpecialLine("ROUND: " + round);
            this.initBoard();
            MoveOutcome outcome = CONTINUE;

            // Make moves till Player 1 wins or Player 2 wins or Draw
            while (outcome.equals(CONTINUE) || outcome.equals(INVALID_MOVE)) {
                // Print instructions to enter the turn
                board.printBoard();
                System.out.print(currentPlayer.getName() + " make your move: x y ");

                // Get input from the user
                int x = getIntegerInput(in);
                int y = getIntegerInput(in);

                // Fill the board and evaluate win or lose
                outcome = board.makeMoveAndEvaluateOutcome(x, y, currentPlayer, player1.getSymbol());
                if (outcome.equals(INVALID_MOVE)) {
                    System.out.println("Invalid move! Please enter again...");
                } else if (outcome.equals(CONTINUE)) {
                    // Change move to next player
                    this.currentPlayer = togglePlayer(this.currentPlayer);
                }
            }

            // Print who won this round
            printRoundOutcomeAndIncrementWinCount(outcome);

            // Evaluate winner or Draw
            if (player1.getNoOfWins() == MIN_WIN_COUNT_TO_WIN_GAME) {
                // Player 1 won
                in.close();
                return Optional.of(player1);
            } else if (player2.getNoOfWins() == MIN_WIN_COUNT_TO_WIN_GAME) {
                // Player 2 won
                in.close();
                return Optional.of(player2);
            }

            // Toggle player symbol and current player
            this.toggleStartingAndCurrentPlayerAndPlayerSymbol();
        }

        // No one won and max rounds are completed
        in.close();
        return Optional.empty();
    }

    private void toggleStartingAndCurrentPlayerAndPlayerSymbol() {
        this.startingPlayer = togglePlayer(this.startingPlayer);
        this.currentPlayer = this.startingPlayer;
        char symbol1 = player1.getSymbol();
        player1.setSymbol(player2.getSymbol());
        player2.setSymbol(symbol1);
    }

    private Player togglePlayer(Player player) {
        return player == player1 ? player2 : player1;
    }

    private void printRoundOutcomeAndIncrementWinCount(MoveOutcome outcome) {
        // Evaluate winner
        Player winner = null;
        if (outcome.equals(PLAYER_1_WON)) {
            winner = player1;
        } else if (outcome.equals(PLAYER_2_WON)) {
            winner = player2;
        }

        // Print statistics
        printSeparator();
        if (Objects.nonNull(winner)) {
            System.out.printf("Round %s winner: %s!%n", round, winner.getName());
            winner.incrementWinCount();
        } else {
            System.out.printf("Round %s is a DRAW!%n", round);
        }
        System.out.printf("%s: won %s rounds.%n", player1.getName(), player1.getNoOfWins());
        System.out.printf("%s: won %s rounds.%n", player2.getName(), player2.getNoOfWins());
        printSeparator();
    }

    private int getIntegerInput(Scanner in) {
        if (in.hasNextInt()) {
            return in.nextInt();
        }
        return -1;
    }

    private void printInstructions() {
        printSpecialLine("INSTRUCTIONS:");
        System.out.println("1. You will have to enter row and column co-ordinates to enter a move.");
        System.out.println("2. Co-ordinates are zero indexed.");
        System.out.printf("3. First player who wins %s rounds out of max of %s rounds wins the game!%n",
                MIN_WIN_COUNT_TO_WIN_GAME, MAX_ROUNDS);
    }

    private void initBoard() {
        board = new Board();
    }

    private void initPlayers() {
        player1 = getPlayer(1, SYMBOL1);
        while (true) {
            player2 = getPlayer(2, SYMBOL2);
            if (player2.getName().equals(player1.getName())) {
                System.out.println("Player 1 and player 2 name can not be same. Please enter again...");
            } else {
                break;
            }
        }
    }

    private Player getPlayer(int i, char symbol) {
        String name = "";
        System.out.printf("Enter player %d name: ", i);
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            name = sc.nextLine().trim();
        }
        return new Player(name, symbol);
    }
}
