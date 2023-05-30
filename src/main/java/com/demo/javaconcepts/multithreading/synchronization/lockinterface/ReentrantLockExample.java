package com.demo.javaconcepts.multithreading.synchronization.lockinterface;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockExample {

    private static int count = 0;
    private static final Lock lock = new ReentrantLock();

    /**
     * If unlock() is not called then no more threads will be able to acquire lock
     * and program will halt forever
     */
    public static void incrementCounter() {
        try {
            lock.lock();
            int current = count;
            log.info("Before: {}", count);
            count = current + 1;
            log.info("After: {}", count);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(ReentrantLockExample::incrementCounter);
            thread.start();
        }
    }
}
