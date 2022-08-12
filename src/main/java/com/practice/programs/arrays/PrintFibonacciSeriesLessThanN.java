package com.practice.programs.arrays;

public class PrintFibonacciSeriesLessThanN {

    /**
     * If n = 1, output: 0
     * If n = 2, output: 0 1 1
     * If n = 9, output 0 1 1 2 3 5 8
     */
    public static void main(String[] args) {
        int n = 9;

        // n = 0, then do nothing
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            System.out.println(0 + " " + 1 + " " + 1);
        } else if (n > 2) {
            int a = 0, b = 1, c = a + b;
            System.out.print(0 + " " + 1 + " ");
            while (c < n) {
                System.out.print(c + " ");
                a = b;
                b = c;
                c = a + b;
            }
        }
    }

}
