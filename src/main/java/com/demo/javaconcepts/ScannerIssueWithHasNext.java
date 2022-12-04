package com.demo.javaconcepts;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerIssueWithHasNext {

    public static void main(String[] args) {
        Scanner sc = new Scanner("11 12" +
                "");
//        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Enter integers...");
        while (sc.hasNextInt()) {
            System.out.println("Has next int: " + sc.hasNextInt());
            al.add(sc.nextInt());
            System.out.println("Added in array list: " + al);
        }
        System.out.println(al);
        sc.close();
    }
}
