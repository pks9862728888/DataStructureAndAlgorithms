package com.demo.javaconcepts.oca8.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToBackedArrayDemo {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> l = new ArrayList<>(Arrays.asList(arr));
        l.set(0, 99);

        // Initially
        System.out.println("Initially: ");
        System.out.println("List: " + l);
        System.out.println("Array: " + Arrays.toString(arr));

        // After backed array modification
        System.out.println("\nAfter when arr size and list size is same: ");
        Integer[] backedArray = l.toArray(arr);  // reference to arr will be returned since size is same
        l.set(1, -999);
        backedArray[2] = 222;
        System.out.println("List: " + l);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("toArray(): " + Arrays.toString(backedArray));

        // Again changing
        System.out.println("\nAfter when arr size and list size is not same: ");
        l.add(5);
        Integer[] backedArray1 = l.toArray(arr);
        backedArray1[3] = 333;
        System.out.println("List: " + l);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("toArray(): " + Arrays.toString(backedArray1));
    }
}
