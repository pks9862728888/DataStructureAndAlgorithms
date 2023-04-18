package com.demo.datastructures.java.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(2, "two");
        tm.put(1, "one");
        tm.put(3, "three");

        // All the below will not maintain insertion order (default ordering is ascending order)
        // Using for each loop
        System.out.println("Using for-each loop");
        tm.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        // Using keySet
        System.out.println("Using keySet: ");
        for (Integer k : tm.keySet()) {  // keySet returns NavigableSet
            System.out.println(k + " " + tm.get(k));
        }

        // using entry set
        System.out.println("Using entrySet:");
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {  // Returns EntrySet
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // To sort in descending order
        System.out.println("Treemap in descending order: ");
        TreeMap<Integer, Integer> tmd = new TreeMap<>((k1, k2) -> -1 * k1.compareTo(k2));
        tmd.put(1, 1);
        tmd.put(3, 3);
        tmd.put(2, 2);
        for (Integer k : tmd.keySet()) {  // keySet returns NavigableSet
            System.out.println(k + " " + tmd.get(k));
        }
    }
}
