package com.practice.programs.revise.hard.bitmanipulation;

public class SwapEvenAndOddBitsOfAnInteger {

    // 22 -> 41
    // The given number is 22 (00010110), it should be converted to 41 (00101001)

    public long swapBits(long n) {
        // return brute(n);
        return optimal(n);
    }

    /**
     * TC: O(1), AS: O(1)
     * These are all constant time, since the integer is a constant number of bits (8)
     */
    private long optimal(long n) {
        // Extract the odd and even digits from number separately
        long evenBitMask = n & 0xAAAAAAAAL;
        long oddBitMask = n & 0x55555555;

        // Right and left shift even and odd digits by 1
        evenBitMask >>= 1;
        oddBitMask <<= 1;

        // Combine both even and odd digits
        return evenBitMask | oddBitMask;
    }

    /**
     * TC: O (no of bits), AS: O(1)
     */
    private long brute(long n) {
        for (int i = 0; i <= 30; i += 2) {
            long bitA = (n & (1L << i)) != 0 ? 1 : 0;
            long bitB = (n & (1L << (i + 1))) != 0 ? 1 : 0;

            if (bitA != bitB) {
                // Toggle the bits
                n = n ^ (1L << i);
                n = n ^ (1L << (i + 1));
            }
        }
        return n;
    }

}
