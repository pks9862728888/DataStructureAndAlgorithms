package com.practice.programs.revise.hard.bitmanipulation;

/**
 * TC: O(1), AS: O(1)
 */
public class CountNoOfBitsToBeFlippedToMakeTwoNumbersEqual {

    // 29 15
    // Binary of 29 is 11101 and Binary of 15 is 01111. So, 2 bits need to be flipped.

    public static int conversion(long a, long b) {
        int count = 0;
        long xorTwoNum = a ^ b;  // only bits where diff exists will be set
        while (xorTwoNum > 0) {  // Find count of set bits
            if ((xorTwoNum & 1) == 1) {
                count++;
            }
            xorTwoNum = xorTwoNum >> 1;
        }
        return count;
    }
}
