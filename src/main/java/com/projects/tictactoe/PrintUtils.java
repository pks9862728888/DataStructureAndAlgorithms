package com.projects.tictactoe;

public interface PrintUtils {

    static void printSeparator() {
        System.out.println("----------------------------------");
    }

    static void printSpecialLine(String line) {
        printSeparator();
        System.out.println(line);
        printSeparator();
    }
}
