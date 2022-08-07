package com.demo.dp;

public class MaxSquareMatrixAllZeros {

    public static void main(String[] args) {
        System.out.println(findMaxSquareWithAllZeros(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }));

        System.out.println(findMaxSquareWithAllZeros(new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}
        }));
    }

    public static int findMaxSquareWithAllZeros(int[][] input) {
        if (input == null || input.length == 0) {
            return 0;
        }

        int ms = 0;
        int[][] memo = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = input[i][j] == 0 ? 1 : 0;
                } else {
                    memo[i][j] = input[i][j] == 1 ? 0 :
                            1 + Math.min(memo[i - 1][j - 1], Math.min(memo[i][j - 1], memo[i - 1][j]));
                }
                ms = Math.max(ms, memo[i][j]);
            }
        }

        return ms;
    }

}