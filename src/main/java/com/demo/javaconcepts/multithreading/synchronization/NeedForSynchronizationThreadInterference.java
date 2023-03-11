package com.demo.javaconcepts.multithreading.synchronization;

public class NeedForSynchronizationThreadInterference {

    private static int counter = 0;

    public static void incrementCounter() {
        int current = counter;
        System.out.printf("Before incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
        counter = current + 1;
        System.out.printf("After incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(NeedForSynchronizationThreadInterference::incrementCounter);
            thread.start();
        }
    }
}
