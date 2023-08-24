package com.practice.programs.medium.recursion.arrays;

import java.util.ArrayList;

public class PrintSubsetSumEqualToK {

    public static void main(String[] args) {
        printSubsetsSumTok(new int[] {4, 3, 1}, 5);
    }
    
	public static void printSubsetsSumTok(int[] arr, int k) {
		print(arr, 0, k, new ArrayList<>());
	}
    
    private static void print(int[] arr, int i, int k, ArrayList<Integer> al) {
        if (k == 0) {
            printArr(al);
            return;
        } else if (i == arr.length) {
            return;
        }
        print(arr, i + 1, k, new ArrayList<>(al));
        al.add(arr[i]);
        print(arr, i + 1, k - arr[i], new ArrayList<>(al));
    }
    
    private static void printArr(ArrayList<Integer> al) {
        for(int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i));
            if (i != al.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}