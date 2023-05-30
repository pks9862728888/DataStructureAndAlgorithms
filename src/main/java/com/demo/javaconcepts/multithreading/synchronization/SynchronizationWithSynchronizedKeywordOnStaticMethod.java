package com.demo.javaconcepts.multithreading.synchronization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizationWithSynchronizedKeywordOnStaticMethod {

    private static int counter = 0;

    /**
     * Guaranteed that objects will be able to access this method in synchronized manner
     * But it is not guaranteed that threads which were created first will have access to this object first
     */
    public static synchronized void increment() {
        int current = counter;
        log.info("Before: {} Thread: {}", counter, Thread.currentThread().getId());
        counter = current + 1;
        log.info("After: {} Thread: {}", counter, Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
        log.info("Count: {}", counter);  // count will always be 20
    }
}
