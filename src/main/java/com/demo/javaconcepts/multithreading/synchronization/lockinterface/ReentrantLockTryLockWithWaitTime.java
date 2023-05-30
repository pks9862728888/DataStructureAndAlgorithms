package com.demo.javaconcepts.multithreading.synchronization.lockinterface;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTryLockWithWaitTime {

    private static int count = 0;
    private static final Lock lock = new ReentrantLock();

    /**
     * If unlock() is not called then no more threads will be able to acquire lock and program will halt forever
     * tryLock() returns false if lock can not be acquired, else true
     * It will keep on retrying till max milliseconds to acquire lock, if it can't then it will return false
     */
    public static void incrementCounter() throws InterruptedException {
        if (lock.tryLock(7, TimeUnit.MILLISECONDS)) {
            try {
                int current = count;
                log.info("Before: {}", count);
                count = current + 1;
                log.info("After: {}", count);
            } finally {
                lock.unlock();
            }
        } else {
            log.info("Thread: {} did not acquire lock so its skipping this task", Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    incrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });
            thread.start();
        }
    }
}
