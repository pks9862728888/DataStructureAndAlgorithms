package com.practice.programs.revise.hard.bitmanipulation;

public class FindTwoNumbersWhichAreNonRepeatingInArray {

    // 2 3 7 9 11 2 3 11 -> 7, 9

    // TC: O(1), AS: O(1)
    // Intuition, since no are non-repeating so for those no ith bit would be set for one of the number
    // So if we separate the no into two bag one having ith bit set and the other not having ith bit set,
    // the two distinct no will go in different bag
    // A ^ A = 0
    // A ^ 0 = A
    static int[] twoNonRepeatingNumbers(int[] nums) {
        // Find sum of numbers which are not repeating
        int sumNonRepeatingEle = 0;
        for (int no: nums) {
            sumNonRepeatingEle = sumNonRepeatingEle ^ no;
        }

        // Find the bit which is set
        int i = 0;
        for (; i < 32; i++) {
            if ((sumNonRepeatingEle & (1 << i)) != 0) {
                break;
            }
        }

        // Separate numbers based on ith bit is set or not
        int no1 = 0;
        int no2 = 0;
        for (int no: nums) {
            if ((no & (1 << i)) != 0) { // ith bit is set
                no1 = no1 ^ no;
            } else {
                no2 = no2 ^ no;
            }
        }
        return new int[] {Math.min(no1, no2), Math.max(no1, no2)};
    }
}
