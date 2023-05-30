package com.demo.javaconcepts.multithreading.synchronization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NeedForSynchronizationThreadInterferance {

    private static int count = 0;

    public static void increment() {
        int current = count;
        log.info("Before: {}", count);
        count = current + 1;
        log.info("After: {}", count);
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
        log.info("Count: {}", count);  // count will not be 20
    }
}
