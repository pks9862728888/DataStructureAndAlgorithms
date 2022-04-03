package com.utils;

import java.util.ArrayList;

public interface Printer {

    static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    static String getAsString(ArrayList<Integer[]> tp) {
        StringBuilder sb = new StringBuilder("[");
        for (Integer[] n: tp) {
            sb.append("(").append(n[0]).append(", ").append(n[1]).append(")");
        }
        sb.append("]");
        return sb.toString();
    }
}
