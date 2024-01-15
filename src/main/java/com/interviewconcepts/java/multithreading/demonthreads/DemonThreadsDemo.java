package com.interviewconcepts.java.multithreading.demonthreads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DemonThreadsDemo {

    /**
     * Daemon threads are low priority threads.
     * System does not wait for daemon thread execution completion
     */
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> getRunnable(200));
        Thread th2 = new Thread(() -> getRunnable(100));

        th1.setDaemon(true); // System does not wait for execution of daemon thread
        th1.start();
//        th1.setDaemon(true); // Once thread is started system does not allow changing thread type to daemon
        th2.start();
    }

    private static void getRunnable(long sleepTimeMs) {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(sleepTimeMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log.info("Thread: {} value: {}", Thread.currentThread().getId(), i);
        }
    }
}
