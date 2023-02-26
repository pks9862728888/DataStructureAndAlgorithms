package com.demo.multithreading.synchronization.lockinterface;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryLockWithoutWaitTime {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    /**
     * If unlock() is not called then no more threads will be able to acquire lock and program will halt forever
     * tryLock() returns false if lock can not be acquired, else true
     * It does not wait if lock can not be acquired
     */
    public static void incrementCounter() {
        if (lock.tryLock()) {
            try {
                int current = counter;
                System.out.printf("Before incrementing: %s Thread: %s%n", counter, Thread.currentThread().threadId());
                counter = current + 1;
                System.out.printf("After incrementing: %s Thread: %s%n", counter, Thread.currentThread().threadId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.printf("Thread: %s did not acquire lock so its skipping this task%n",
                    Thread.currentThread().threadId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }
}
