package com.demo.javaconcepts.runtime;

import java.util.ArrayList;

public class GettingRuntimeInfo {

    /**
     * Run with this value in VM options: -Xms1024m -Xmx2048m
     */
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        populateObjects(1000000);

        System.out.println("Used memory: " + getSizeInMB(runtime.totalMemory() - runtime.freeMemory()));
        System.out.println("Free memory: " + getSizeInMB(runtime.freeMemory()));

        // Free memory + Used memory
        System.out.println("Total memory: " + getSizeInMB(runtime.totalMemory()));

        // Free memory + used memory + unallocated memory
        System.out.println("Max memory: " + getSizeInMB(runtime.maxMemory()));

        System.out.println(runtime.availableProcessors());
    }

    private static void populateObjects(int n) {
        ArrayList<Object> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new Object());
        }
    }

    private static String getSizeInMB(long bytes) {
        return bytes * 1.0 / 1024 / 1024 + " MB";
    }
}
