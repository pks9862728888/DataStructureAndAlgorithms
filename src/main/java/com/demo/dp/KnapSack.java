package com.demo.dp;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {
        System.out.println(knapsackRecursively(new int[] {1, 2, 4, 5}, new int[] {5, 4, 8, 6}, 4, 5));
        System.out.println(knapsackIteratively(new int[] {1, 2, 4, 5}, new int[] {5, 4, 8, 6}, 4, 5));
    }

    public static int knapsackIteratively(int[] wt, int[] val, int n, int w) {
        int[][] memo = new int[n][w + 1];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                memo[i][j] = sack(j, wt, val, i, memo);
            }
        }

        return memo[0][w];
    }

	public static int knapsackRecursively(int[] wt, int[] val, int n, int w) {
        int[][] memo = new int[n][w + 1];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        
		return sack(w, wt, val, 0, memo);
	}
    
    private static int sack(int w, int[] wt, int[] val, int i, int[][] memo) {
        if (i == val.length) {
            return 0;
        } else if (memo[i][w] != -1) {
            return memo[i][w];
        }
        int maxVal;
        if (wt[i] <= w) {
            maxVal = Math.max(
                val[i] + sack(w - wt[i], wt, val, i + 1, memo),  // Including the ele
                sack(w, wt, val, i + 1, memo)                    // Excluding the ele
            );
        } else {
            maxVal = sack(w, wt, val, i + 1, memo);
        }
        memo[i][w] = maxVal;
        return maxVal;
    }

}