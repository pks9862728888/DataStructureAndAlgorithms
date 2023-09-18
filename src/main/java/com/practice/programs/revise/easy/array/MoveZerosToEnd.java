package com.practice.programs.revise.easy.array;

/**
 * TC: O(n), AS: O(1)
 * Concept: Two pointer
 * <a href="https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/">Practice link</a>
 */
class MoveZerosToEnd {

    public static int[] moveZeros(int n, int []arr) {
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                arr[++i] = arr[j];
                if (i != j) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }
}
