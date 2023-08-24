package com.practice.programs.easy.arrays;

class SummedMatrix {

    /**
     * A matrix is constructed of size n*n. such that Mi,j= i+j.
     * Count the number of cells having value q.
     * Note: Assume, the array is in 1-based indexing.
     * <p>
     * Constraints:
     * TC: O(1), AS: O(1)
     */
    public static void main(String[] args) {
        System.out.println(sumMatrix(4, 7));
        System.out.println(sumMatrix(5, 4));
    }

    private static long sumMatrix(long n, long q) {
        if (n >= q) {
            return q - 1;
        } else {
            long ans = 2 * n - (q - 1);
            return ans < 0 ? 0 : ans;
        }
    }
};
