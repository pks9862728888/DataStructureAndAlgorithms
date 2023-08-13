package com.demo.javaconcepts.oca8.collectionframework;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListBackedArrayDemo {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        List<Integer> l = Arrays.asList(arr); // Backed array, any change in list or arr gets reflected

        // Before
        System.out.println("Before: ");
        System.out.println("List: " + l);
        System.out.println("Array: " + Arrays.toString(arr));

        // After
        System.out.println("\nAfter modification: ");
        arr[0] = -1;
        l.set(1, 222);
        System.out.println("List: " + l);
        System.out.println("Array: " + Arrays.toString(arr));

        // Resizing / deletion operations are not allowed since backed array
//        l.remove(0);  // throws UnsupportedOperationException
    }
}
