package com.practice.programs.revise.hard.bitmanipulation;

/**
 * TC: O(1), AS: O(1)
 */
public class ReverseBitsOfGivenUnsignedInteger {

    // 00000010100101000001111010011100 -> 00111001011110000010100101000000
    // Input is 32 bit integer

    static long reverseBits(long n) {
        long res = 0;
        int count = 0;
        while (count++ < 32) {
            res = res << 1;
            if ((n & 1) == 1) {
                res = res ^ 1;
            }
            n = n >> 1;
        }
        return res;
    }
}
