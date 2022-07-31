package com.demo.dp;

import java.util.Arrays;

public class MinSquaresToRepresentNumber {

    /**
     * Given an integer N, find and return the count of minimum numbers required to
     * represent N as a sum of squares.
     * TC: O(n Root (n)) AS: O(n)
     **/
    public static void main(String[] args) {
        System.out.println("3: " + minCount(3));
        System.out.println("41: " + minCount(41));
        System.out.println("12: " + minCount(12));
    }

    public static int minCount(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            getMinCount(i, dp);
        }

        return dp[n];
    }

    private static int getMinCount(int n, int[] dp) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int res = n - (i * i);
            if (dp[res] == -1) {
                dp[res] = getMinCount(res, dp);
            }
            min = Math.min(min, dp[res]);
        }
        dp[n] = min + 1;
        return min;
    }

}