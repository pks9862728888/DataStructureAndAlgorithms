package com.demo.javaconcepts.io;

import java.util.Scanner;

public class ScannerIssue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Highlighting nextInt() does not consume trailing new line character
        System.out.println("Enter an integer and then a string...");
        System.out.print("Integer: " + sc.nextInt());
        System.out.print("String: " + sc.nextLine());

        sc.close();
    }
}
