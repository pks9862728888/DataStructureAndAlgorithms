package com.demo.datastructures.map;

import java.util.*;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        lhm.put(1, 1);
        lhm.put(2, 2);
        lhm.put(3, 3);

        // All the below will maintain insertion order
        // Using for each loop
        System.out.println("Using for-each loop");
        lhm.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        // Using keySet
        System.out.println("Using keySet: ");
        for (Integer k: lhm.keySet()) {  // keySet returns LinkedKeySet
            System.out.println(k + " " + lhm.get(k));
        }

        // using entry set
        System.out.println("Using entrySet:");
        for (Map.Entry<Integer, Integer> entry: lhm.entrySet()) {  // Returns LinkedEntrySet
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
