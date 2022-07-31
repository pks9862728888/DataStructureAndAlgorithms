package com.demo.dp;

import java.util.Arrays;

public class MinStepsTo1 {

    public static void main(String[] args) {
        // n <= 10 ^ 4, then we can safely use recursive solution
        // TC: O(n), AS: O(n)
        System.out.println(countMinStepsToOneRecursiveDp(10));

        // If n <= 10 ^ 6, then we need to use iterative solution else we will get stack overflow error
        // TC: O(n), AS: O(n)
        System.out.println(countMinStepsToOneIterativeDp(10));
    }

    /**
     * Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
     * 1. Subtract 1 from it. (n = n - 1) ,
     * 2. If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
     * 3. If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
     */
    public static int countMinStepsToOneRecursiveDp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getMinStepsRecursiveDp(n, dp);
	}

    /**
     * Get the values of all possible paths and calculate min.
     */
    public static int getMinStepsRecursiveDp(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        int c3;
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                dp[n / 3] = getMinStepsRecursiveDp(n / 3, dp);
            }
            c3 = dp[n / 3];
        } else {
            c3 = Integer.MAX_VALUE;
        }
        int c2;
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                dp[n / 2] = getMinStepsRecursiveDp(n / 2, dp);
            }
            c2 = dp[n / 2];
        } else {
            c2 = Integer.MAX_VALUE;
        }
        if (dp[n - 1] == -1) {
            dp[n - 1] = getMinStepsRecursiveDp(n - 1, dp);
        }
        int c1 = dp[n - 1];
        
        return Math.min(c3, Math.min(c2, c1)) + 1;
    }

    public static int countMinStepsToOneIterativeDp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = getMinStepsIterativeDp(i, dp);
        }
        return dp[n];
    }

    private static int getMinStepsIterativeDp(int n, int[] dp) {
        if (n <= 1) {
            return 0;
        }
        int c3;
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                dp[n / 3] = getMinStepsIterativeDp(n / 3, dp);
            }
            c3 = dp[n / 3];
        } else {
            c3 = Integer.MAX_VALUE;
        }
        int c2;
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                dp[n / 2] = getMinStepsIterativeDp(n / 2, dp);
            }
            c2 = dp[n / 2];
        } else {
            c2 = Integer.MAX_VALUE;
        }
        if (dp[n - 1] == -1) {
            dp[n - 1] = getMinStepsIterativeDp(n - 1, dp);
        }
        int c1 = dp[n - 1];

        return Math.min(c3, Math.min(c2, c1)) + 1;
    }

}