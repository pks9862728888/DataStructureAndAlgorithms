package com.practice.programs.revise.hard.bitmanipulation;

/**
 * TC: O(1), AS: O(1)
 */
public class CountNoOfBitsInAnInteger {

    // 2 -> 101 -> ans = 2

    static int numberOfOneBits(long n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
