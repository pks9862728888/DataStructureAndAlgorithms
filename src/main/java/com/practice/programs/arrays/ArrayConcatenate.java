package com.practice.programs.arrays;

import java.util.Arrays;

public class ArrayConcatenate {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {12, 9, 7};
        int[] arr3 = new int[arr1.length + arr2.length];

        // Copy first array elements
        for(int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }

        // Copy second array elements
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + arr1.length] = arr2[i];
        }

        // Print third array
        System.out.println(Arrays.toString(arr3));
    }
}
