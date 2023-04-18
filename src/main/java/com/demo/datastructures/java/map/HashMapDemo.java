package com.demo.datastructures.java.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("1", 1);
        hm.put("2", 2);
        hm.put("3", 3);
        hm.put("4", 4);
        hm.put("5", 5);

        // All the below will not maintain insertion order
        // Using for each loop
        System.out.println("Using for-each loop");
        hm.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        // Using keySet
        System.out.println("Using keySet: ");
        for (String k : hm.keySet()) {  // keySet returns eySet
            System.out.println(k + " " + hm.get(k));
        }

        // using entry set
        System.out.println("Using entrySet:");
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {  // Returns EntrySet
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
