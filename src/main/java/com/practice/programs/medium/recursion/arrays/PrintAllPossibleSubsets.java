package com.practice.programs.medium.recursion.arrays;

import java.util.*;

public class PrintAllPossibleSubsets {

    public static void main(String[] args) {
        printSubsets(new int[] {15, 20, 12});
    }
    
	public static void printSubsets(int[] arr) {
		printSubsets(arr, 0, new ArrayList<>());
	}
    
    private static void printSubsets(int[] arr, int idx, ArrayList<Integer> l) {
        if (idx == arr.length) {
            print(l);
            return;
        }
        printSubsets(arr, idx + 1, new ArrayList<>(l));
        l.add(arr[idx]);
        printSubsets(arr, idx + 1, new ArrayList<>(l));
    }
    
    private static void print(ArrayList<Integer> l) {
        for(int e: l) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}