package com.demo.dp;

import java.util.Arrays;

public class NthFibonacciNumber {

    public static void main(String[] args) {
        int n = 5;
        int[] fibArray = new int[n + 1];
        Arrays.fill(fibArray, -1);
        System.out.println(getNthFibonacciNumber(n, fibArray));
        System.out.println(Arrays.toString(fibArray));

        int n1 = 5;
        int[] fibArray1 = new int[n + 1];
        Arrays.fill(fibArray1, -1);
        System.out.println(getNthFibonacciNumberIterativeDp(n, fibArray1));
        System.out.println(Arrays.toString(fibArray1));
    }

    /**
     * TC : O (n)
     * AS: O (n)
     */
    private static int getNthFibonacciNumberIterativeDp(int n, int[] fibArray1) {
        fibArray1[0] = 0;
        fibArray1[1] = 1;

        // Iterative DP
        for (int i = 2; i <= n; i++) {
            fibArray1[i] = fibArray1[i - 1] + fibArray1[i - 2];
        }

        return fibArray1[n];
    }

    /**
     * TC : O (n)
     * AS: O (n)
     */
    private static int getNthFibonacciNumber(int n, int[] fibArray) {
        if (n == 0 || n == 1) {
            fibArray[n] = n;
            return n;
        }

        // Calculate fibonacci number
        int fib1 = fibArray[n - 1];
        int fib2 = fibArray[n - 2];
        if (fib1 == -1) {
            fib1 = getNthFibonacciNumber(n - 1, fibArray);
        }
        if (fib2 == -1) {
            fib2 = getNthFibonacciNumber(n - 2, fibArray);
        }

        // Return the number
        fibArray[n] = fib1 + fib2;  // Memoization
        return fibArray[n];
    }
}
