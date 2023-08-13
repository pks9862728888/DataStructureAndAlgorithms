package com.demo.javaconcepts.oca8.collectionframework;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListFromPrimitives {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<int[]> list = Arrays.asList(arr);  // Calling asList() on primitive array results in list(object)
        System.out.println(Arrays.toString(list.get(0)));
    }
}
