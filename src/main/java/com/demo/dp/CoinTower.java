package com.demo.dp;

public class CoinTower {

    /**
     * A and B are playing a new game today. T
     * hey form a tower of N coins and make a move in alternate turns. 
     * B plays first. In one step, the player can remove either 1, X, or Y coins from the tower. 
     * The person to make the last move wins the game. Can you find out who wins the game?
     */
    public static void main(String[] args) {
        System.out.println(findWinner(5, 3, 4));
    }

	public static String findWinner(int n, int x, int y) {
		boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!dp[i - 1] || i >= x && !dp[i - x] || i >= y && !dp[i - y]) {
                dp[i] = true;
            }
        }
        return !dp[n] ? "A" : "B";
	}

}