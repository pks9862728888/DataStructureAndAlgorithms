package com.demo.multithreading.synchronization;

public class SynchronizationWithLocks {

    private static int counter = 0;
    private static final Object lock = new Object();

    /**
     * Guaranteed that objects will be able to access this method in synchronized manner
     * But it is not guaranteed that threads which were created first will have access to this object first
     * We can also synchronize on this for non-static methods but that will only gain lock on that object,
     * Threads created from other object might still be able to access it concurrently.
     */
    public static void incrementCounter() {
        synchronized (lock) {
            int current = counter;
            System.out.printf("Before incrementing: %s Thread: %s%n", counter, Thread.currentThread().threadId());
            counter = current + 1;
            System.out.printf("After incrementing: %s Thread: %s%n", counter, Thread.currentThread().threadId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }
}
