package com.demo.dp;

public class LootHouses {

    /**
     * A thief wants to loot houses.
     * He knows the amount of money in each house. He cannot loot two consecutive houses.
     * Find the maximum amount of money he can loot.
     */
    public static void main(String[] args) {
        System.out.println(maxMoneyLooted(new int[]{5, 5, 10, 100, 10, 5}));
        System.out.println(maxMoneyLooted(new int[]{2, 3, 1000, 2000}));
    }

    public static int maxMoneyLooted(int[] houses) {
        if (houses == null || houses.length == 0) {
            return 0;
        } else if (houses.length <= 2) {
            return Math.max(houses[0], houses[1]);
        }
        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        int maxLoot = Math.max(dp[0], dp[1]);

        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(houses[i] + dp[i - 2], dp[i - 1]);
            maxLoot = Math.max(maxLoot, dp[i]);
        }

        return maxLoot;
    }

}