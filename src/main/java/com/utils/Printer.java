package com.utils;

public interface Printer {

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
