package com.demo.datastructures.java.map;

public class CustomHashMapDemo {

    public static void main(String[] args) {
        loadFactorDemo();
    }

    private static void loadFactorDemo() {
        CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
        map.put(1, 1);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
        map.put(1, 2);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
        map.put(2, 2);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
        map.put(3, 3);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
        map.put(4, 4);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
        System.out.println(map);
        map.delete(1);
        System.out.println(map);
        System.out.println(map.getCurrentLoadFactor() + " " + map.size());
    }
}
