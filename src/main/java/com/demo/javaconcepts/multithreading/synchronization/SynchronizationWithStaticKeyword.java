package com.demo.javaconcepts.multithreading.synchronization;

public class SynchronizationWithStaticKeyword {

    private static int counter = 0;

    /**
     * Guaranteed that objects will be able to access this method in synchronized manner
     * But it is not guaranteed that threads which were created first will have access to this object first
     */
    public static synchronized void incrementCounter() {
        int current = counter;
        System.out.printf("Before incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
        counter = current + 1;
        System.out.printf("After incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }
}
