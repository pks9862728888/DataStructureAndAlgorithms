package com.practice.programs.revise.medium.algorithms;


import java.util.Arrays;

/**
 * TC: O(n), AS: O(1)
 * <a href="https://leetcode.com/problems/count-primes/description/">Practice link</a>
 */
public class SeiveOfEratothenesCountNoOrPrimeLessThanN {

    public int countPrimes(int n) {
        // Use array to store the prime numbers
        // For each prime no in array upto sqrt(n), mark all multiples of curr no >= no * no as non prime
        boolean[] res = new boolean[n];
        Arrays.fill(res, true);
        res[0] = false;
        res[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (res[i]) {
                // Mark all multiples of prime no as non prime
                for (int j = i * i; j < n; j += i) {
                    res[j] = false;
                }
            }
        }

        // Count no of prime numbers in array
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) {
                c++;
            }
        }
        return c;
    }
}
