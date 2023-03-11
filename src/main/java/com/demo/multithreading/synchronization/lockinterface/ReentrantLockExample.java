package com.demo.multithreading.synchronization.lockinterface;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    /**
     * If unlock() is not called then no more threads will be able to acquire lock and program will halt forever
     */
    public static void incrementCounter() {
        try {
            lock.lock();
            int current = counter;
            System.out.printf("Before incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
            counter = current + 1;
            System.out.printf("After incrementing: %s Thread: %s%n", counter, Thread.currentThread().getId());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }
}
