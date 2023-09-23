package com.practice.programs.easy.arrays;

/**
 * TC: O(log n), AS: O(1)
 */
public class FindFirstOccurrenceOfOneInArrayOfZeroAndOne {

    // 0 0 1 1 -> 2

    static int zeroOnes(int n, int a[]) {
        int idx = -1;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m] == 1) {
                idx = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return idx;
    }

}
