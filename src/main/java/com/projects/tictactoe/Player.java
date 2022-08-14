package com.projects.tictactoe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class Player {

    private String name;
    private int noOfWins;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void incrementWinCount() {
        this.noOfWins += 1;
    }
}
